
-- 테이블 삭제
drop table AccountBook;
-- seq 초기화
alter table AccountBook auto_increment = 0; 

-- 테이블 생성
create table AccountBook (
    seq int auto_increment primary key,
    Type varchar(5) not null,
    Amount decimal(10, 2) not null,
    Category varchar(20) not null,
    Place varchar(100),
    Memo varchar(1000),
    Date timestamp not null,
    constraint chk_Type check (Type in ('In', 'Out')),
    constraint chk_Category check (Category in ('식비', '주거비', '교통비', '취미', '의류미용', '의료건강', '기타', '수입'))
);


-- select
select * from AccountBook;
select seq, Type, Amount, Category, Place, Memo, DATE(Date) from AccountBook
order by Date;

-- insert (더미데이터)
insert into AccountBook(Type,Amount,Category,Place,Memo,Date)
values 	('in', 2500000, '수입', '월급', '7월 월급', '2023-08-15'),
		('out', 30000, '식비', '신선횟집', '친구와 스시세트 먹음', '2023-08-17'),
		('in', 500000, '주거비', '집주인', '수도세 및 청소비', '2023-08-20'),
		('out', 150000, '의류미용', '무신사', '신상 옷 구매', '2023-08-22'),
		('in', 1000000, '교통비', '한국교통', '지하철비', '2023-08-25'),
		('out', 50000, '식비', '맥도날드', '점심식사', '2023-08-27'),
		('in', 800000, '취미', '스피드짐', '헬스장 회원비', '2023-08-29'),
		('out', 200000, '취미', '메가박스', '영화 관람', '2023-09-01'),
		('in', 3000000, '의료건강', '해피의원', '검진비', '2023-09-03'),
		('out', 100000, '의료건강', '해피약국', '의약품 구매', '2023-09-05'),
		('in', 600000, '기타', '이케아', '친구 결혼 선물', '2023-09-08'),
		('out', 80000, '의류미용', '무신사', '신발 구매', '2023-09-10'),
		('in', 2000000, '기타', '한국주식', '투자 수익', '2023-09-12'),
		('out', 70000, '취미', '스피드짐', '운동기구 사용료', '2023-09-15'),
		('in', 400000, '주거비', '집주인', '집 수리 및 보수비', '2023-09-18'),
		('out', 300000, '교통비', '에스오일', '주유비', '2023-09-20'),
		('in', 1500000, '의료건강', '반짝치과', '치아 보철비', '2023-09-22'),
		('out', 120000, '의류미용', '무신사', '옷 구매', '2023-09-25'),
		('in', 900000, '기타', '네이버스토어', '판매 수익', '2023-09-28'),
		('out', 50000, '식비', '맥도날드', '저녁식사', '2023-09-30'),
		('in', 2500000, '수입', '월급', '10월 월급', '2023-11-15'),
		('out', 30000, '식비', '신선횟집', '친구와 스시세트 먹음', '2023-11-17'),
		('in', 500000, '주거비', '집주인', '수도세 및 청소비', '2023-11-20'),
		('out', 150000, '의류미용', '무신사', '신상 옷 구매', '2023-11-22'),
		('in', 1000000, '교통비', '한국교통', '지하철비', '2023-11-25'),
		('out', 50000, '식비', '서브웨이', '점심식사', '2023-11-27'),
		('in', 800000, '취미', '스피드짐', '헬스장 회원비', '2023-11-29'),
		('out', 200000, '취미', '메가박스', '영화 관람', '2023-12-01'),
		('in', 3000000, '의료건강', '해피의원', '검진비', '2023-12-03'),
		('out', 100000, '의료건강', '해피약국', '의약품 구매', '2023-12-05'),
		('in', 600000, '기타', '이케아', '친구 결혼 선물', '2023-12-08'),
		('out', 80000, '의류미용', '무신사', '신발 구매', '2023-12-10'),
		('in', 2000000, '수입', '한국주식', '투자 수익', '2023-12-12'),
		('out', 70000, '취미', '스피드짐', '운동기구 사용료', '2023-12-15'),
		('in', 400000, '주거비', '집주인', '집 수리 및 보수비', '2023-12-18'),
		('out', 300000, '교통비', '에스오일', '주유비', '2023-12-20'),
		('in', 1500000, '의료건강', '반짝치과', '치아 보철비', '2023-12-22'),
		('out', 120000, '의류미용', '무신사', '옷 구매', '2023-12-25'),
		('in', 900000, '수입', '네이버스토어', '판매 수익', '2023-12-28');
	
insert into AccountBook(Type,Amount,Category,Place,Memo,Date)
values 	('in', 2500000, '수입', '월급', '6월 월급', '2023-07-10'),
		('out', 500000, '기타', '이케아', '선반 구입', '2023-07-14'),
		('out', 100000, '의류미용', '헤어샬롱', '헤어 매직', '2023-07-20');
		
-- delete
delete from AccountBook
where seq = 1;

-- update
update AccountBook 
set Type = 'in', 
Amount = 55, 
Category = '수입', 
Place = '월급',
Memo = '월급임',
Date = '2023-12-12'
where seq = 1;


-- select : date
select seq, Type, Amount, Category, Place, Memo, DATE(Date) 
from AccountBook 
where Date = '2023-12-15'
order by Date;

-- select : place
select seq, Type, Amount, Category, Place, Memo, DATE(Date) 
from AccountBook 
where Place like '%장%'
order by Date;

-- select : memo
select seq, Type, Amount, Category, Place, Memo, DATE(Date) 
from AccountBook 
where replace(Memo, ' ', '') like '%옷구%'
order by Date;

-- select : category
select seq, Type, Amount, Category, Place, Memo, DATE(Date) 
from AccountBook 
where Category = '수입'
order by Date;
 
-- select : period
select seq, Type, Amount, Category, Place, Memo, DATE(Date) 
from AccountBook 
where Date >= '2023-12-01' and Date <= '2023-12-15'
order by Date;


-- 월별 결산
select 	DATE_FORMAT(Date, '%Y-%m') as Month,
		sum(case when Type = 'in' THEN Amount else 0 END) AS inAmount,
		sum(case when Type = 'out' THEN Amount else 0 END) AS outAmount
from AccountBook
group by DATE_FORMAT(Date, '%Y-%m')
order by Month;

-- 전체 결산
SELECT 	'all' as Month,
		SUM(CASE WHEN Type = 'in' THEN Amount ELSE 0 END) AS inAmount,
		SUM(CASE WHEN Type = 'out' THEN Amount ELSE 0 END) AS outAmount
FROM AccountBook;


select
seq, Type, Amount, Category, Place, Memo, DATE(Date) as Date 
where Date = '2023-12-15'
order by Date
