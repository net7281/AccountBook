

-- 테이블 생성
create table AccountBook (
    seq int  auto_increment primary key,
    Type varchar(5) not null,
    Amount decimal(10, 2) not null,
    Category varchar(20) not null,
    Place varchar(100),
    Memo varchar(1000),
    Date timestamp not null,
    constraint chk_Type check (Type in ('In', 'Out')),
    constraint chk_Category check (Category in ('식비', '주거비', '교통비', '취미', '의류미용', '의료건강', '기타'))
);


-- select
select * from AccountBook;

