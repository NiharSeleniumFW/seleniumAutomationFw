package com.Vtiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateconditionGroup {
	public class CreateConditionGroup {
		@FindBy(id="save_conditions_add")
		private WebElement CreateCondition;
		@FindBy(className="fieldname")
		private WebElement CreateFieldName;
}
