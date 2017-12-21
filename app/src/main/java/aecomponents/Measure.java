package aecomponents;

import engine.Component;
import engine.ComponentType;
import engine.MeasurementType;

public abstract class Measure extends Component 
{
	protected MeasurementType measurementType;
	
	public MeasurementType getMeasurementType() {
		return measurementType;
	}

	public Measure() 
	{
		setType(ComponentType.MEASURE);
	}
}
