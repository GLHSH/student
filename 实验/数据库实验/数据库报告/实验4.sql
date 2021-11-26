实验四

1．查找每一个供应商供应的商品的名称，要求显示供应商名称和商品名称。
select sname,cname 
from supplier,supplying,commodity
where supplier.sid=supplying.sid
      and supplying.cid=commodity.cid

2．使用连接查询查找与姓名为‘李云’的采购员签订采购单的供应商的名称。
select distinct(sname)
from stock,employee,supplier
where stock.Eid=employee.Eid and supplier.Sid=stock.Sid
      and Ename='李云'

3．使用关键字IN完成查询，要求查找与姓名为‘李云’的采购员签订采购单的供应商的名称。
select sname from supplier
where sid in
( select sid from stock where eid in
  ( select eid from employee where ename='李云')
 )

4．使用左外连接完成如下查询：要求查找所有采购员签订的采购合同的详细信息。
select * 
from  employee left join stock
on stock.Eid=employee.Eid
     


5．使用左外连接完成如下查询：查找所有客户购买的商品详细信息，要求显示客户名称，
商品名称，销售数量，商品单价，没有购买商品的客户也要显示。
select CUname,Cname,SDnumber,SDprice
FROM customer left join sale
on customer.CUid=sale.CUid
LEFT JOIN saleDetail
ON sale.SAid=saleDetail.SAid
LEFT JOIN commodity
ON saleDetail.Cid=commodity.cid


6．请使用内连接完成如下查询：查找每一个供应商供应的商品的种类，要求显示供应商名称，供应的商品的种类。
select sname,count(cid)
from supplying INNER JOIN supplier
ON supplying.sid=supplier.sid
group by supplier.sid,sname

7．查找购买了编号为‘A001’的供应商供应的商品的客户名称
select CUname FROM customer
where CUid IN
 ( select CUid from sale where SAid in
   (select SAid from saleDetail WHERE Cid IN
    (select CId from Supplying where Sid='A001')
   )
 )

8．查找销售员‘王良’在2005年签订的销售合同的详细信息。
  SELECT * FROM sale
  where Year(SAdate)=2005 and EId IN
  (select Eid from employee where Ename='王良' and Etype=3)

三、自我测试
1．使用右外连接完成如下查询：要求查找所有采购员签订的采购合同的详细信息，没有签订采购单的采购员也要显示
   select *
   from stock right join employee
   on stock.Eid=employee.Eid
   where Etype=2 
2．查找购买了名称为‘联想集团’的供应商供应的商品的客户名称
   select CUname from customer
   where CUId IN
   ( select CUid from sale where SAid IN
      ( select SAid from saleDetail where Cid IN
         (select Cid from supplying where Sid IN
           (select Sid from supplier where Sname='联想集团')
         )
      )
    )