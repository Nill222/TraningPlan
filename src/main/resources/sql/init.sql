
create table day_of_the_week (
    name_of_the_day VARCHAR(20) PRIMARY KEY
);

create table exercise (
        name_of_exercise VARCHAR(255) PRIMARY KEY
);

create table training_week (
    id BIGSERIAL PRIMARY KEY,
    week_number int,
    repetitions varchar(255),
    number_of_approaches int,
    name varchar(255) not null references exercise(name_of_exercise) on delete cascade,
    day varchar(20) not null references day_of_the_week(name_of_the_day) on delete cascade
);

