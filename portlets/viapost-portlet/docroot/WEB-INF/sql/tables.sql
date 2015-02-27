create table Viapost_Demande (
	demandeId LONG not null primary key,
	question VARCHAR(75) null,
	request VARCHAR(75) null
);

create table Viapost_EtapeDemande (
	etapeId LONG not null primary key,
	demandeId LONG,
	decription VARCHAR(75) null,
	order_ LONG
);

create table Viapost_Product (
	stockId LONG not null primary key,
	articleNumber LONG,
	stock LONG,
	seuil_stock LONG
);

create table Viapost_UserDemande (
	userDemandeId LONG not null primary key,
	demandeId LONG,
	userId LONG,
	companyId LONG,
	groupId LONG,
	date_ DATE null,
	origine VARCHAR(75) null,
	article LONG,
	resourcePrimaryKey LONG,
	title VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusByDate DATE null
);