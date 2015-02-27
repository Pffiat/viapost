create table feedback_Feedback (
	uuid_ VARCHAR(75) null,
	feedbackId LONG not null primary key,
	feedbackDate DATE null,
	feedbackText TEXT null,
	feedbackSubject STRING null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	companyId LONG,
	groupId LONG,
	userId LONG
);