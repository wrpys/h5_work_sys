<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>作业系统 简介</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .row80{width: 90%;margin-left: auto;margin-right: auto;padding: 10px 5px 5px 0px;}
        .row80 h2{text-align: center;}
        .row80 div{padding: 0 70px;}
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="row row80">
    <h2>作业系统简介</h2>
    <div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建服务器应用程序和服务的Java 2平台企业版（Java 2 Platform Enterprise Edition，J2EE）。J2EE是一种利用Java 2平台来简化企业解决方案的开发、部署和管理相关的复杂问题的体系结构。J2EE技术的基础就是核心Java平台或Java 2平台的标准版，J2EE不仅巩固了标准版中的许多优点，例如"编写一次、随处运行"的特性、方便存取数据库的JDBC API、CORBA技术以及能够在Internet应用中保护数据的安全模式等等，同时还提供了对 EJB（Enterprise JavaBeans）、Java Servlets API、JSP（Java Server Pages）以及XML技术的全面支持。其最终目的就是成为一个能够使企业开发者大幅缩短投放市场时间的体系结构。
        J2体系结构提供中间层集成框架用来满足无需太多费用而又需要高可用性、高可靠性以及可扩展性的应用的需求。通过提供统一的开发平台，J2EE降低了开发多层应用的费用和复杂性，同时提供对现有应用程序集成强有力支持，完全支持Enterprise JavaBeans，有良好的向导支持打包和部署应用，添加目录支持，增强了安全机制，提高了性能。
    </div>
    <div>
    <h3>J2EE的优势</h3>
        <h4>1. 保留现存的IT资产:</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由于企业必须适应新的商业需求，利用已有的企业信息系统方面的投资，而不是重新制定全盘方案就变得很重要。这样，一个以渐进的（而不是激进的，全盘否定的）方式建立在已有系统之上的服务器端平台机制是公司所需求的。J2EE架构可以充分利用用户原有的投资，如一些公司使用的BEA Tuxedo、IBM CICS, IBM Encina,、Inprise VisiBroker 以及Netscape Application Server。这之所以成为可能是因为J2EE拥有广泛的业界支持和一些重要的'企业计算'领域供应商的参与。每一个供应商都对现有的客户提供了不用废弃已有投资，进入可移植的J2EE领域的升级途径。由于基于J2EE平台的产品几乎能够在任何操作系统和硬件配置上运行，现有的操作系统和硬件也能被保留使用。
        <h4>2. 高效的开发:</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J2EE允许公司把一些通用的、很繁琐的服务端任务交给中间件供应商去完成。这样开发人员可以集中精力在如何创建商业逻辑上，相应地缩短了开发时间。高级中间件供应商提供以下这些复杂的中间件服务: o 状态管理服务 -- 让开发人员写更少的代码，不用关心如何管理状态，这样能够更快地完成程序开发。 o 持续性服务 -- 让开发人员不用对数据访问逻辑进行编码就能编写应用程序，能生成更轻巧，与数据库无关的应用程序，这种应用程序更易于开发与维护。 o 分布式共享数据对象CACHE服务 -- 让开发人员编制高性能的系统，极大提高整体部署的伸缩性。
        <h4>3. 支持异构环境:</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; J2EE能够开发部署在异构环境中的可移植程序。基于J2EE的应用程序不依赖任何特定操作系统、中间件、硬件。因此设计合理的基于J2EE的程序只需开发一次就可部署到各种平台。这在典型的异构企业计算环境中是十分关键的。J2EE标准也允许客户订购与J2EE兼容的第三方的现成的组件，把他们部署到异构环境中，节省了由自己制订整个方案所需的费用。
        <h4>4. 可伸缩性:</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;企业必须要选择一种服务器端平台，这种平台应能提供极佳的可伸缩性去满足那些在他们系统上进行商业运作的大批新客户。基于J2EE平台的应用程序可被部署到各种操作系统上。例如可被部署到高端UNIX与大型机系统，这种系统单机可支持64至256个处理器。（这是NT服务器所望尘莫及的）J2EE领域的供应商提供了更为广泛的负载平衡策略。能消除系统中的瓶颈，允许多台服务器集成部署。这种部署可达数千个处理器，实现可高度伸缩的系统，满足未来商业应用的需要。
        <h4>5.稳定的可用性:</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一个服务器端平台必须能全天候运转以满足公司客户、合作伙伴的需要。因为INTERNET是全球化的、无处不在的，即使在夜间按计划停机也可能造成严重损失。若是意外停机，那会有灾难性后果。J2EE部署到可靠的操作环境中，他们支持长期的可用性。一些J2EE部署在WINDOWS环境中，客户也可选择健壮性能更好的操作系统如Sun Solaris、IBM OS/390。最健壮的操作系统可达到99.999%的可用性或每年只需5分钟停机时间。这是实时性很强商业系统理想的选择。
    <h3>J2EE 的四层模型</h3>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J2EE使用多层的分布式应用模型，应用逻辑按功能划分为组件，各个应用组件根据他们所在的层分布在不同的机器上。事实上，sun设计J2EE的初衷正是为了解决两层模式(client/server)的弊端，在传统模式中，客户端担当了过多的角色而显得臃肿，在这种模式中，第一次部署的时候比较容易，但难于升级或改进，可伸展性也不理想，而且经常基于某种专有的协议??通常是某种数据库协议。它使得重用业务逻辑和界面逻辑非常困难。现在J2EE 的多层企业级应用模型将两层化模型中的不同层面切分成许多层。一个多层化应用能够为不同的每种服务提供一个独立的层，以下是 J2EE 典型的四层结构:
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运行在客户端机器上的客户层组件
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运行在J2EE服务器上的Web层组件
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运行在J2EE服务器上的业务逻辑层组件
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;运行在EIS服务器上的企业信息系统(Enterprise information system)层软件
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J2EE应用程序组件
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J2EE应用程序是由组件构成的.J2EE组件是具有独立功能的软件单元，它们通过相关的类和文件组装成J2EE应用程序，并与其他组件交互。J2EE说明书中定义了以下的J2EE组件:
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;应用客户端程序和applets是客户层组件.
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java Servlet和JavaServer Pages(JSP)是web层组件.
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enterprise JavaBeans(EJB)是业务层组件.
        <h4>客户层组件</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J2EE应用程序可以是基于web方式的,也可以是基于传统方式的.
        <h4>web 层组件</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J2EE web层组件可以是JSP 页面或Servlets.按照J2EE规范，静态的HTML页面和Applets不算是web层组件。
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正如下图所示的客户层那样，web层可能包含某些 JavaBean 对象来处理用户输入，并把输入发送给运行在业务层上的enterprise bean 来进行处理。
        <h4>业务层组件</h4>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业务层代码的逻辑用来满足银行，零售，金融等特殊商务领域的需要,由运行在业务层上的enterprise bean 进行处理. 下图表明了一个enterprise bean 是如何从客户端程序接收数据，进行处理(如果必要的话), 并发送到EIS 层储存的，这个过程也可以逆向进行。
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有三种企业级的bean: 会话(session) beans, 实体(entity) beans, 和消息驱动(message-driven) beans. 会话bean 表示与客户端程序的临时交互. 当客户端程序执行完后, 会话bean 和相关数据就会消失. 相反, 实体bean 表示数据库的表中一行永久的记录. 当客户端程序中止或服务器关闭时, 就会有潜在的服务保证实体bean 的数据得以保存.消息驱动 bean 结合了会话bean 和 JMS的消息监听器的特性, 允许一个业务层组件异步接收JMS 消息.
        <h4>企业信息系统层</h4>
        企业信息系统层处理企业信息系统软件包括企业基础建设系统例如企业资源计划(ERP), 大型机事务处理, 数据库系统,和其它的遗留信息系统. 例如，J2EE 应用组件可能为了数据库连接需要访问企业信息系统
    </div>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>