
--1．查找所有商品的名称和库存信息
   select Cname,Cstorage from commodity;

--2．查找‘北京’地区的供应商
   select * from supplier where Sarea='北京';

--3．查找所有销售人员的基本信息
   select * from Employee where Etype=3;

--4．查找签订日期在‘2005-5-1’和‘2006-3-1’之间签订的采购单的基本信息
   select * from Stock where CGdate between '2005-5-1' and '2006-3-1';

--5．查找2006年签订的所有销售单，要求显示销售单ID、客户ID和销售单总金额
   select SAid,CUid,SAmoney
   from sale
   where Year(SAdate)=2006;

--6．查找每个采购员所签订的采购单的数目，显示结果按采购单数目降序排序
   select Eid,count(*) as number
   from stock
   group by Eid
   order by number DESC;

--7．查询每个销售员签订的销售单总金额
   select Eid, sum(SAmoney) as totalMoney
   from sale
   group by Eid;

--8．查找2005年与每个客户签订的销售单的总金额，只显示总金额大于50万的客户ID和总金额
    select CUid, sum(SAmoney) 
    from sale
    where Year(SAdate)=2005
    group by Cuid
    having sum(SAmoney)>50;

--9．查询2005年签订的金额最大的一笔销售单，要求显示销售员ID、客户ID和销售金额
   select Eid,CUid,SAmoney
   from sale
   where SAmoney>=
   (select max(SAmoney) from sale where Year(SAdate)=2005)
   and Year(SAdate)=2005;


--10．查询2005年与编号为‘A002’的供应商签订的所有采购单的总金额
    select sum(CGmoney)
    from stock
    where Sid='A002' and Year(CGdate)=2005;

--11．查询名称中含有‘机’字的所有商品的ID、名称和库存量
    select Cid,Cname,Cstorage
    from commodity
    where Cname like '%机%';

--12．查找第二个汉字是‘翔’的商品名称和均价。
    select Cname,avgPrice
    from commodity
    where Cname like '_翔%';


--三、自我测试
--1．查询2005年签订的销售合同总额排名前5名的销售员的ID和合同总额，要求结果按照合同总额降序排列
   select top 5 Eid, Sum(SAmoney) as money2005
   from sale
   where Year(SAdate)=2005
   group by Eid
   order by money2005 DESC;

--2．查询至少供应了3种商品的供应商的ID
   select Sid
   from supplying
   group by Sid
   having count(*)>=3;

--3．查询在2006年至少已经与2名销售员签订了合同的客户ID
   select CUid
   from sale
   where Year(SAdate)=2006
   group by CUid
   having count(distinct Eid)>=2;
