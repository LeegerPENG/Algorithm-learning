## Chapter 7 Network Flow

[华文慕课](http://www.chinesemooc.org/course.php?ac=course_view&id=710264&eid=28780&key=0)

**the maximum-flow problem**

* Given a flow network, goal is to arrange the traffic so as to make as efficient use as possible of the available capacity.      

**Designing the Algorithm**

* dynamic programming DOES NOT work
* go back and think about greedy  algorithm

**容量网络的定义**

* 有向连通图  
  $$
  G=（V,G）
  $$
  

* 容量（capacity） 
  $$
  c_e>=0 
  $$
  对于每一条边e

* 发点（source node） s∈V

* 收点（sink node） t∈V

**Defining Flow **

* the value of f(e) intuitively represents the amount of flow carried by edge e.

* properties

  * (**Capacity conditions**)For each e∈E，

    
    $$
    0<=f(e)<=c_e
    $$

  * (**Conservation conditions**)For each node v other than s and t, we have
    $$
    \sum_{e\ into\  v} f(e)= \sum_{e\ out\ of\  v}f(e)
    $$

  * 满足上述条件的f，称为G上的一个可行流

* The value of a flow f, denoted v(f), is defined to be the amount of flow generated at the source
  $$
  v(f)=\sum_{e\ out \ of\ s}f(e)
  $$
  解释：发点s的净流出量为f的流量

* 最大流：流量最大的可行流 f*

**最大流问题的线性规划表述**

* 在特定的条件下，使得v(f)最大

**割集（cut）、割集的容量、最小割集**

* 设容量网络N=<V,E,c,s,t>

* A∈V 且 s∈A，t∈A‘

* 称
  $$
  （A，A'） = \{<i,j>|<i,j>∈E\ and\ i∈A，j∈A'\}
  $$
  为N的割集。(也就是边的集合）

* $$
  c(A,A')=\sum_{<i,j>∈（A,A’）}c(i,j)
  $$

  称为割集（A,A'）的**容量**。

**可行流的流量与割集上的流量**

