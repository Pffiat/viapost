create index IX_4E7397E3 on feedback_Feedback (companyId);
create index IX_815062B on feedback_Feedback (feedbackText);
create index IX_5AB6BB25 on feedback_Feedback (groupId);
create index IX_37EE050B on feedback_Feedback (groupId, status);
create index IX_6E1AD2EF on feedback_Feedback (uuid_);
create index IX_63A155D9 on feedback_Feedback (uuid_, companyId);
create unique index IX_C1077E9B on feedback_Feedback (uuid_, groupId);