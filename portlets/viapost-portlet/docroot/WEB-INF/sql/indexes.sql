create index IX_505E8DDB on Viapost_Demande (demande);
create index IX_EB24B5C9 on Viapost_Demande (question);
create index IX_615EAFB0 on Viapost_Demande (request);

create index IX_630BE5FB on Viapost_EtapeDemande (demandeId);

create index IX_80647369 on Viapost_UserDemande (resourcePrimaryKey, status);
create index IX_49CE1C5E on Viapost_UserDemande (userId);