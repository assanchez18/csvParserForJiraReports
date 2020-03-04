package helpers;

public enum Headers {
		SUMMARY("Summary"),
		ISSUE_KEY("Issue key"),
		ISSUE_ID("Issue id"),
		ISSUE_TYPE("Issue Type"),
		STATUS("Status"),
		PRIORITY("Priority"),
		ASSIGNEE("Assignee"),
		CREATED("Created"),
		UPDATED("Updated"),
		LABEL("Labels"),
		DESCRIPTION("Description"),
		EPIC_NAME("Custom field (Epic Name)"),
		COMMENT("Comment");//can appear several times
		 
		public final String label;
		 
		private Headers(String label) {
			this.label = label;
		}
		
}

