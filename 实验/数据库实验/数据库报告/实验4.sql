ʵ����

1������ÿһ����Ӧ�̹�Ӧ����Ʒ�����ƣ�Ҫ����ʾ��Ӧ�����ƺ���Ʒ���ơ�
select sname,cname 
from supplier,supplying,commodity
where supplier.sid=supplying.sid
      and supplying.cid=commodity.cid

2��ʹ�����Ӳ�ѯ����������Ϊ�����ơ��Ĳɹ�Աǩ���ɹ����Ĺ�Ӧ�̵����ơ�
select distinct(sname)
from stock,employee,supplier
where stock.Eid=employee.Eid and supplier.Sid=stock.Sid
      and Ename='����'

3��ʹ�ùؼ���IN��ɲ�ѯ��Ҫ�����������Ϊ�����ơ��Ĳɹ�Աǩ���ɹ����Ĺ�Ӧ�̵����ơ�
select sname from supplier
where sid in
( select sid from stock where eid in
  ( select eid from employee where ename='����')
 )

4��ʹ����������������²�ѯ��Ҫ��������вɹ�Աǩ���Ĳɹ���ͬ����ϸ��Ϣ��
select * 
from  employee left join stock
on stock.Eid=employee.Eid
     


5��ʹ����������������²�ѯ���������пͻ��������Ʒ��ϸ��Ϣ��Ҫ����ʾ�ͻ����ƣ�
��Ʒ���ƣ�������������Ʒ���ۣ�û�й�����Ʒ�Ŀͻ�ҲҪ��ʾ��
select CUname,Cname,SDnumber,SDprice
FROM customer left join sale
on customer.CUid=sale.CUid
LEFT JOIN saleDetail
ON sale.SAid=saleDetail.SAid
LEFT JOIN commodity
ON saleDetail.Cid=commodity.cid


6����ʹ��������������²�ѯ������ÿһ����Ӧ�̹�Ӧ����Ʒ�����࣬Ҫ����ʾ��Ӧ�����ƣ���Ӧ����Ʒ�����ࡣ
select sname,count(cid)
from supplying INNER JOIN supplier
ON supplying.sid=supplier.sid
group by supplier.sid,sname

7�����ҹ����˱��Ϊ��A001���Ĺ�Ӧ�̹�Ӧ����Ʒ�Ŀͻ�����
select CUname FROM customer
where CUid IN
 ( select CUid from sale where SAid in
   (select SAid from saleDetail WHERE Cid IN
    (select CId from Supplying where Sid='A001')
   )
 )

8����������Ա����������2005��ǩ�������ۺ�ͬ����ϸ��Ϣ��
  SELECT * FROM sale
  where Year(SAdate)=2005 and EId IN
  (select Eid from employee where Ename='����' and Etype=3)

�������Ҳ���
1��ʹ����������������²�ѯ��Ҫ��������вɹ�Աǩ���Ĳɹ���ͬ����ϸ��Ϣ��û��ǩ���ɹ����Ĳɹ�ԱҲҪ��ʾ
   select *
   from stock right join employee
   on stock.Eid=employee.Eid
   where Etype=2 
2�����ҹ���������Ϊ�����뼯�š��Ĺ�Ӧ�̹�Ӧ����Ʒ�Ŀͻ�����
   select CUname from customer
   where CUId IN
   ( select CUid from sale where SAid IN
      ( select SAid from saleDetail where Cid IN
         (select Cid from supplying where Sid IN
           (select Sid from supplier where Sname='���뼯��')
         )
      )
    )