create table if not exists accounts (
id serial primary key,
site text not null unique,
login text not null unique,
password text not null unique
);

comment on table accounts is 'Таблица аккаунтов сайтов, зарегистрированных в сервисе';
comment on column accounts.id is 'Идентификатор аккаунта';
comment on column accounts.site is 'Домен сайта';
comment on column accounts.login is 'Логин';
comment on column accounts.password is 'Пароль';