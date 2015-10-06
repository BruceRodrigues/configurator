package br.ufsc.configurator.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.ufsc.configurator.api.field.ConfigColumn;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.configurator.api.listener.CoreBlurListener;
import br.ufsc.configurator.api.listener.CoreClickListener;
import br.ufsc.configurator.api.listener.CoreFocusListener;
import br.ufsc.configurator.api.listener.CoreGetDtoChangeListener;
import br.ufsc.configurator.api.listener.CoreShortCutListener;
import br.ufsc.configurator.api.listener.CoreValueChangeListener;
import br.ufsc.configurator.api.strategy.LayoutStrategy;
import lombok.Getter;
import lombok.Setter;

public class ViewConfigurator {

	private LinkedHashMap<Integer, List<ConfigField>> components = new LinkedHashMap<Integer, List<ConfigField>>();

	private LinkedHashMap<Object, List<ConfigColumn>> columns = new LinkedHashMap<Object, List<ConfigColumn>>();

	private Map<Object, List<CoreBlurListener<?>>> blurListeners = new HashMap<Object, List<CoreBlurListener<?>>>();
	private Map<Object, List<CoreClickListener>> clickListeners = new HashMap<Object, List<CoreClickListener>>();
	private Map<Object, List<CoreFocusListener>> focusListeners = new HashMap<Object, List<CoreFocusListener>>();
	private Map<Object, List<CoreShortCutListener>> shortCutListeners = new HashMap<Object, List<CoreShortCutListener>>();
	private Map<Object, List<CoreValueChangeListener>> valueChangeListeners = new HashMap<Object, List<CoreValueChangeListener>>();
	private Map<Object, List<CoreGetDtoChangeListener<?>>> getDtoChangeListeners = new HashMap<Object, List<CoreGetDtoChangeListener<?>>>();

	@Getter
	@Setter
	private String viewWidth;

	private ViewConfiguration factories;

	private Integer totalLines = 1;

	public ViewConfigurator() {
		this.init();
	}

	protected void init() {
		for (Integer i = 0; i < this.totalLines; i++) {
			this.components.put(i, new ArrayList<ConfigField>());
		}
	}

	public String getViewWidth() {
		return this.viewWidth;
	}

	public void setViewWidth(String value) {
		this.viewWidth = value;
	}

	public void setFactories(ViewConfiguration factories) {
		this.factories = factories;
	}

	public ViewConfiguration getFactories() {
		return this.factories;
	}

	public void addBlurListener(Object componentId, CoreBlurListener<?> listener) {
		if (this.blurListeners.containsKey(componentId)) {
			this.blurListeners.get(componentId).add(listener);
		} else {
			List<CoreBlurListener<?>> listeners = new ArrayList<CoreBlurListener<?>>();
			listeners.add(listener);
			this.blurListeners.put(componentId, listeners);
		}
	}

	public void addClickListener(Object componentId, CoreClickListener listener) {
		if (this.clickListeners.containsKey(componentId)) {
			this.clickListeners.get(componentId).add(listener);
		} else {
			List<CoreClickListener> listeners = new ArrayList<CoreClickListener>();
			listeners.add(listener);
			this.clickListeners.put(componentId, listeners);
		}
	}

	public void addFocusListener(Object componentId, CoreFocusListener listener) {
		if (this.focusListeners.containsKey(componentId)) {
			this.focusListeners.get(componentId).add(listener);
		} else {
			List<CoreFocusListener> listeners = new ArrayList<CoreFocusListener>();
			listeners.add(listener);
			this.focusListeners.put(componentId, listeners);
		}
	}

	public void addShortCutListener(Object componentId, CoreShortCutListener listener) {
		if (this.shortCutListeners.containsKey(componentId)) {
			this.shortCutListeners.get(componentId).add(listener);
		} else {
			List<CoreShortCutListener> listeners = new ArrayList<CoreShortCutListener>();
			listeners.add(listener);
			this.shortCutListeners.put(componentId, listeners);
		}
	}

	public void addValueChangeListener(Object componentId, CoreValueChangeListener listener) {
		if (this.valueChangeListeners.containsKey(componentId)) {
			this.valueChangeListeners.get(componentId).add(listener);
		} else {
			List<CoreValueChangeListener> listeners = new ArrayList<CoreValueChangeListener>();
			listeners.add(listener);
			this.valueChangeListeners.put(componentId, listeners);
		}
	}

	public <DTO> void addGetDtoChangeListener(Object componentId, CoreGetDtoChangeListener<DTO> listener) {
		if (this.getDtoChangeListeners.containsKey(componentId)) {
			this.getDtoChangeListeners.get(componentId).add(listener);
		} else {
			List<CoreGetDtoChangeListener<?>> listeners = new ArrayList<CoreGetDtoChangeListener<?>>();
			listeners.add(listener);
			this.getDtoChangeListeners.put(componentId, listeners);
		}
	}

	public List<CoreBlurListener<?>> getBlurListener(Object componentId) {
		return this.blurListeners.get(componentId);
	}

	public List<CoreClickListener> getClickListener(Object componentId) {
		return this.clickListeners.get(componentId);
	}

	public List<CoreFocusListener> getFocusListener(Object componentId) {
		return this.focusListeners.get(componentId);
	}

	public List<CoreShortCutListener> getShortCutListener(Object componentId) {
		return this.shortCutListeners.get(componentId);
	}

	public List<CoreValueChangeListener> getValueChangeListener(Object componentId) {
		return this.valueChangeListeners.get(componentId);
	}

	public List<CoreGetDtoChangeListener<?>> getGetDtoChangeListener(Object componentId) {
		return this.getDtoChangeListeners.get(componentId);
	}

	public void addComponent(ConfigField configField) {
		if (configField.getLine() == -1) {
			configField.setLine(this.totalLines);
		}
		if (configField.getLine() >= 0 && configField.getLine() >= this.totalLines) {
			this.addLines(configField.getLine() - this.totalLines + 1);
		}
		if (configField.getPosition() == -1) {
			this.components.get(configField.getLine()).add(configField);
		} else {
			this.components.get(configField.getLine()).add(configField.getPosition(), configField);
		}
	}

	public void addColumn(ConfigColumn configColumn) {
		if (this.columns.get(configColumn.getTableConstant()) == null) {
			this.columns.put(configColumn.getTableConstant(), new ArrayList<ConfigColumn>());
		}
		if (configColumn.getPosition() == -1) {
			this.columns.get(configColumn.getTableConstant()).add(configColumn);
		} else {
			this.columns.get(configColumn.getTableConstant()).add(configColumn.getPosition(), configColumn);
		}
	}

	private void addConfigField(Integer line, int position, ConfigField field) {
		this.components.get(line).add(position, field);
	}

	public LayoutStrategy<?> createLayout(ConfigField field) {
		return (LayoutStrategy<?>) this.factories.getLayoutFactory().createComponent(field);
	}

	public LayoutStrategy<?> createPanel(ConfigSubComponent config) {
		return ((PanelFactory<?>) this.factories.getFactory(ConfigFieldType.PANEL)).createPanel(config);
	}

	public ConfigField removeComponent(Object constant) {
		int line = this.getComponentLine(constant);
		for (int index = 0; index < this.components.get(line).size(); index++) {
			if (this.components.get(line).get(index).getFieldConstant().equals(constant)) {
				return this.components.get(line).remove(index);
			}
		}
		return null;
	}

	private ConfigField removeConfigField(Object constant) {
		int line = this.getComponentLine(constant);
		for (int index = 0; index < this.components.get(line).size(); index++) {
			if (this.components.get(line).get(index).getFieldConstant().equals(constant)) {
				return this.components.get(line).remove(index);
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	private ConfigField removeConfigField(Object constant, Integer line) {
		for (int index = 0; index < this.components.get(line).size(); index++) {
			if (this.components.get(line).get(index).getFieldConstant().equals(constant)) {
				return this.components.get(line).remove(index);
			}
		}
		return null;
	}

	public Integer getFirstEmptyLine() {
		Iterator<Entry<Integer, List<ConfigField>>> it = this.components.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, List<ConfigField>> entry = it.next();
			if (entry.getValue().isEmpty()) {
				return entry.getKey();
			}
		}
		return this.totalLines;
	}

	public Integer getTotalLines() {
		return this.totalLines;
	}

	public void setTotalLines(Integer totalLines) {
		if (this.totalLines > totalLines) {
			for (Integer i = this.totalLines; i != totalLines; i--) {
				this.components.remove(i);
			}
		} else {
			for (Integer i = this.totalLines; i != totalLines; i++) {
				this.addLine(new ArrayList<ConfigField>());
			}
		}
		this.totalLines = totalLines;
	}

	public void addLines(int quant) {
		for (int i = 0; i < quant; i++) {
			this.addLine();
		}
	}

	public void addLine() {
		this.addLine(new ArrayList<ConfigField>());
	}

	public void addLine(List<ConfigField> line) {
		this.components.put(this.totalLines, line);
		this.totalLines++;
	}

	public List<ConfigField> getComponents(Integer line) {
		return this.components.get(line);
	}

	public List<ConfigColumn> getColumns(Object tableConstant) {
		return this.columns.get(tableConstant);
	}

	public ConfigField getComponentConfig(Object constant) {
		int line = this.getComponentLine(constant);
		for (int index = 0; index < this.components.get(line).size(); index++) {
			if (this.components.get(line).get(index).getFieldConstant().equals(constant)) {
				return this.components.get(line).get(index);
			}
		}
		return null;
	}

	public Integer getComponentLine(Object componentConstant) {
		Iterator<Entry<Integer, List<ConfigField>>> iterator = this.components.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, List<ConfigField>> entry = iterator.next();
			for (ConfigField configField : entry.getValue()) {
				if (configField.getFieldConstant().equals(componentConstant)) {
					return entry.getKey();
				}
			}
		}
		return -1;
	}

	/**
	 * Check if the component which key is @param contains in any line. If True,
	 * return the line number, otherwise return -1.
	 *
	 * @param componentConstant
	 * @return
	 */
	public Integer contains(Object componentConstant) {
		return this.getComponentLine(componentConstant);
	}

	protected <T> List<T> clone(Collection<T> collection) {
		List<T> cloneList = new ArrayList<T>();
		for (T t : collection) {
			cloneList.add(t);
		}
		return cloneList;
	}

	public boolean moveToLine(Object componentConstant, Integer destinyLine) {
		Integer line = this.getComponentLine(componentConstant);
		if (line != -1) {
			ConfigField component = this.removeConfigField(componentConstant);
			this.components.get(destinyLine).add(component);
			return true;
		}
		return false;
	}

	public void moveTo(Object componentConstant, Integer line, int position) {
		this.moveToLine(componentConstant, line);
		this.moveToPosition(componentConstant, position, line);
	}

	public void moveToPosition(Object componentConstant, int position, Integer componentLine) {
		this.addConfigField(componentLine, position, this.removeConfigField(componentConstant));
	}

	public boolean moveToPosition(Object componentConstant, int position) {
		int line = this.getComponentLine(componentConstant);
		if (line != -1) {
			this.moveToPosition(componentConstant, position, line);
			return true;
		}
		return false;
	}

}
