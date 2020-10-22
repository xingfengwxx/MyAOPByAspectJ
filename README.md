# 使用AspectJ实现AOP的Demo

## AOP之前传统代码实现的问题 

- 代码高度耦合，牵一发动全身 
- 违背了单一职责原则 
- 不便于扩展维护，不优雅

## AOP架构设计

- Aspect Oriented Programming 
- 面向切面编程 
- 利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率
- 在Spring中提供了面向切面编程的丰富支持，例如transaction

## Aspectj编译器 

![](\art\img_0.png)

## Aspectj语言体系

- Aspect：Aspect 声明类似于 Java 中的类声明，在 Aspect 中会包含着一些 Pointcut 以及 相应的 Advice。 
- Joint point：表示在程序中明确定义的点，典型的包括方法调用，对类成员的访问以及异常处理程序块的执行等等，它自身还可以嵌套其它 joint point。 
- Pointcut：表示一组 joint point，这些 joint point 或是通过逻辑关系组合起来，或是通过 通配、正则表达式等方式集中起来，它定义了相应的 Advice 将要发生的地方。
- Advice：Advice 定义了在 pointcut 里面定义的程序点具体要做的操作，它通过 before、 after 和 around 来区别是在每个 joint point 之前、之后还是代替执行的代码。