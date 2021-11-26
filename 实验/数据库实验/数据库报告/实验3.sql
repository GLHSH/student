
--1������������Ʒ�����ƺͿ����Ϣ
   select Cname,Cstorage from commodity;

--2�����ҡ������������Ĺ�Ӧ��
   select * from supplier where Sarea='����';

--3����������������Ա�Ļ�����Ϣ
   select * from Employee where Etype=3;

--4������ǩ�������ڡ�2005-5-1���͡�2006-3-1��֮��ǩ���Ĳɹ����Ļ�����Ϣ
   select * from Stock where CGdate between '2005-5-1' and '2006-3-1';

--5������2006��ǩ�����������۵���Ҫ����ʾ���۵�ID���ͻ�ID�����۵��ܽ��
   select SAid,CUid,SAmoney
   from sale
   where Year(SAdate)=2006;

--6������ÿ���ɹ�Ա��ǩ���Ĳɹ�������Ŀ����ʾ������ɹ�����Ŀ��������
   select Eid,count(*) as number
   from stock
   group by Eid
   order by number DESC;

--7����ѯÿ������Աǩ�������۵��ܽ��
   select Eid, sum(SAmoney) as totalMoney
   from sale
   group by Eid;

--8������2005����ÿ���ͻ�ǩ�������۵����ܽ�ֻ��ʾ�ܽ�����50��Ŀͻ�ID���ܽ��
    select CUid, sum(SAmoney) 
    from sale
    where Year(SAdate)=2005
    group by Cuid
    having sum(SAmoney)>50;

--9����ѯ2005��ǩ���Ľ������һ�����۵���Ҫ����ʾ����ԱID���ͻ�ID�����۽��
   select Eid,CUid,SAmoney
   from sale
   where SAmoney>=
   (select max(SAmoney) from sale where Year(SAdate)=2005)
   and Year(SAdate)=2005;


--10����ѯ2005������Ϊ��A002���Ĺ�Ӧ��ǩ�������вɹ������ܽ��
    select sum(CGmoney)
    from stock
    where Sid='A002' and Year(CGdate)=2005;

--11����ѯ�����к��С������ֵ�������Ʒ��ID�����ƺͿ����
    select Cid,Cname,Cstorage
    from commodity
    where Cname like '%��%';

--12�����ҵڶ��������ǡ��衯����Ʒ���ƺ;��ۡ�
    select Cname,avgPrice
    from commodity
    where Cname like '_��%';


--�������Ҳ���
--1����ѯ2005��ǩ�������ۺ�ͬ�ܶ�����ǰ5��������Ա��ID�ͺ�ͬ�ܶҪ�������պ�ͬ�ܶ������
   select top 5 Eid, Sum(SAmoney) as money2005
   from sale
   where Year(SAdate)=2005
   group by Eid
   order by money2005 DESC;

--2����ѯ���ٹ�Ӧ��3����Ʒ�Ĺ�Ӧ�̵�ID
   select Sid
   from supplying
   group by Sid
   having count(*)>=3;

--3����ѯ��2006�������Ѿ���2������Աǩ���˺�ͬ�Ŀͻ�ID
   select CUid
   from sale
   where Year(SAdate)=2006
   group by CUid
   having count(distinct Eid)>=2;
