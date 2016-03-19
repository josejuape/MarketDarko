<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	<meta name="description" content="Dashboard" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="#" rel="stylesheet" />
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <link href="assets/css/weather-icons.min.css" rel="stylesheet" />

    <!--Beyond styles-->
    <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/gallery.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/demo.min.css" rel="stylesheet" />
    <link href="assets/css/typicons.min.css" rel="stylesheet" />
    <link href="assets/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="#" rel="stylesheet" type="text/css" />

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="assets/js/skins.min.js"></script>
</head>
<body>

	<!-- Loading Container -->
    <div class="loading-container">
        <div class="loader"></div>
    </div>
    <!--  /Loading Container -->
    <!-- Navbar -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="navbar-container">
                <!-- Navbar Barnd -->
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>
                            <img src="assets/img/logo.png" alt="" />
                        </small>
                    </a>
                </div>
                <!-- /Navbar Barnd -->
                <!-- Sidebar Collapse -->
                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="collapse-icon fa fa-bars"></i>
                </div>
                <div class="navbar-header pull-right">
                    <div class="navbar-account">
                        <ul class="account-area">                            
                            <li>
                                <a class="dropdown-toggle" data-toggle="dropdown" title="Mails" href="#">
                                    <i class="icon fa fa-envelope"></i>
                                    <span class="badge">3</span>
                                </a>
                                <!--Messages Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-arrow dropdown-messages">
                                    <li>
                                        <a href="#">
                                            <img src="assets/img/avatars/divyia.jpg" class="message-avatar" alt="Divyia Austin">
                                            <div class="message">
                                                <span class="message-sender">
                                                    Zapatillas
                                                </span>
                                                <span class="message-time">
                                                    S/ 220.00
                                                </span>
                                                <span class="message-subject">
                                                    Quicksilver - Modelo 145kl
                                                </span>
                                                <span class="message-body">
                                                    Color: Azul dorado
                                                </span>
                                                <button class="btn-quitarprod" onclick="" alt="Quitar">x</button> 
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <img src="assets/img/avatars/bing.png" class="message-avatar" alt="Microsoft Bing">
                                            <div class="message">
                                                <span class="message-sender">
                                                    Polos
                                                </span>
                                                <span class="message-time">
                                                    S/ 89.00
                                                </span>
                                                <span class="message-subject">
                                                    DC - Modelo Cuello V
                                                </span>
                                                <span class="message-body">
                                                    Color: Blanco
                                                </span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <img src="assets/img/avatars/adam-jansen.jpg" class="message-avatar" alt="Divyia Austin">
                                            <div class="message">
                                                <span class="message-sender">
                                                    Nicolas
                                                </span>
                                                <span class="message-time">
                                                    Friday, September 22
                                                </span>
                                                <span class="message-subject">
                                                    New 4K Cameras
                                                </span>
                                                <span class="message-body">
                                                    The 4K revolution has come over the horizon and is reaching the general populous
                                                </span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="box-btn-confirm">
                                            <a href="javascript:realizarVenta();">Realizar venta</a>
                                        </div>
                                    </li>
                                </ul>
                                <!--/Messages Dropdown-->
                            </li>
                            <li>
                                <a class="dropdown-toggle" data-toggle="dropdown" title="Tasks" href="#">
                                    <i class="icon fa fa-tasks"></i>
                                    <span class="badge">4</span>
                                </a>
                                <!--Tasks Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-tasks dropdown-arrow ">
                                    <li class="dropdown-header bordered-darkorange">
                                        <i class="fa fa-tasks"></i>
                                        4 Tasks In Progress
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="clearfix">
                                                <span class="pull-left">Account Creation</span>
                                                <span class="pull-right">65%</span>
                                            </div>

                                            <div class="progress progress-xs">
                                                <div style="width:65%" class="progress-bar"></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="clearfix">
                                                <span class="pull-left">Profile Data</span>
                                                <span class="pull-right">35%</span>
                                            </div>

                                            <div class="progress progress-xs">
                                                <div style="width:35%" class="progress-bar progress-bar-success"></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="clearfix">
                                                <span class="pull-left">Updating Resume</span>
                                                <span class="pull-right">75%</span>
                                            </div>

                                            <div class="progress progress-xs">
                                                <div style="width:75%" class="progress-bar progress-bar-darkorange"></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="clearfix">
                                                <span class="pull-left">Adding Contacts</span>
                                                <span class="pull-right">10%</span>
                                            </div>

                                            <div class="progress progress-xs">
                                                <div style="width:10%" class="progress-bar progress-bar-warning"></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="dropdown-footer">
                                        <a href="#">
                                            See All Tasks
                                        </a>
                                        <button class="btn btn-xs btn-default shiny darkorange icon-only pull-right"><i class="fa fa-check"></i></button>
                                    </li>
                                </ul>
                                <!--/Tasks Dropdown-->
                            </li>
                            <li>
                                <a class="login-area dropdown-toggle" data-toggle="dropdown">
                                    <div class="avatar" title="View your public profile">
                                        <img src="assets/img/avatars/adam-jansen.jpg">
                                    </div>
                                    <section>
                                        <h2><span class="profile"><span>David Stevenson</span></span></h2>
                                    </section>
                                </a>
                                <!--Login Area Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area">
                                    
                                </ul>
                                <!--/Login Area Dropdown-->
                            </li>
                            <!-- /Account Area -->
                            <!--Note: notice that setting div must start right after account area list.
                            no space must be between these elements-->
                            <!-- Settings -->
                        
                        <!-- Settings -->
                    </div>
                </div>
                <!-- /Account Area and Settings -->
            </div>
        </div>
    </div>
    <!-- /Navbar -->
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">

            <!-- Page Sidebar -->
            <div class="page-sidebar" id="sidebar">
                <!-- Page Sidebar Header-->
                <div class="sidebar-header-wrapper">
                    <input type="text" class="searchinput" />
                    <i class="searchicon fa fa-search"></i>
                    <div class="searchhelper">Search Reports, Charts, Emails or Notifications</div>
                </div>
                <!-- /Page Sidebar Header -->
                <!-- Sidebar Menu -->
                <ul class="nav sidebar-menu">
                    <!--Dashboard-->
                    <li class="active">
                        <a href="index.html">
                            <i class="menu-icon fa fa-th"></i>
                            <span class="menu-text">Catálogo </span>
                        </a>
                    </li>
                     
                    <c:forEach var="menu" items="${listaopciones}">
                    	<c:if test="${menu.nodo == menu.nodo_padre}">
                    		<li>
				                <a href="#" class="menu-dropdown">
		                            <i class="menu-icon ${ menu.icon_menu }"></i>
		                            <span class="menu-text">${ menu.desc_menu }</span>
		                            <i class="menu-expand"></i>
		                        </a>
		                        <ul class="submenu">
		                        	<c:forEach var="submenu" items="${listaopciones}">
		                        		<c:if test="${submenu.nodo != submenu.nodo_padre && submenu.nodo_padre == menu.nodo }">
		                        			<li>
				                                <a href="javascript:${ submenu.url_menu };">
				                                    <span class="menu-text">${ submenu.desc_menu }</span>
				                                </a>
				                            </li>
		                        		</c:if>
		                        	</c:forEach>
		                        </ul>
	                        </li>
                    	</c:if>
                    </c:forEach>                      
                                          
                    <li>
                        <a href="versions.html">
                            <i class="menu-icon glyphicon glyphicon-fire themesecondary"></i>
                            <span class="menu-text">
                                Developed by @JoseJuape
                            </span>
                        </a>
                    </li>
                </ul>
                <!-- /Sidebar Menu -->
            </div>
            <!-- /Page Sidebar -->
            <!-- Chat Bar -->
            <div id="chatbar" class="page-chatbar">
                <div class="chatbar-contacts">
                    <div class="contacts-search">
                        <input type="text" class="searchinput" placeholder="Search Contacts" />
                        <i class="searchicon fa fa-search"></i>
                        <div class="searchhelper">Search Your Contacts and Chat History</div>
                    </div>
                    <ul class="contacts-list">
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/divyia.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Divyia Philips</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    last week
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/Nicolai-Larson.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Adam Johnson</div>
                                <div class="contact-status">
                                    <div class="offline"></div>
                                    <div class="status">left 4 mins ago</div>
                                </div>
                                <div class="last-chat-time">
                                    today
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/John-Smith.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">John Smith</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    1:57 am
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/Osvaldus-Valutis.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Osvaldus Valutis</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    today
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/Javi-Jimenez.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Javi Jimenez</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    today
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/Stephanie-Walter.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Stephanie Walter</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    yesterday
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/Sergey-Azovskiy.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Sergey Azovskiy</div>
                                <div class="contact-status">
                                    <div class="offline"></div>
                                    <div class="status">offline since oct 24</div>
                                </div>
                                <div class="last-chat-time">
                                    22 oct
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/Lee-Munroe.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Lee Munroe</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    today
                                </div>
                            </div>
                        </li>
                        <li class="contact">
                            <div class="contact-avatar">
                                <img src="assets/img/avatars/divyia.jpg" />
                            </div>
                            <div class="contact-info">
                                <div class="contact-name">Divyia Philips</div>
                                <div class="contact-status">
                                    <div class="online"></div>
                                    <div class="status">online</div>
                                </div>
                                <div class="last-chat-time">
                                    last week
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="chatbar-messages" style="display: none;">
                    <div class="messages-contact">
                        <div class="contact-avatar">
                            <img src="assets/img/avatars/divyia.jpg" />
                        </div>
                        <div class="contact-info">
                            <div class="contact-name">Divyia Philips</div>
                            <div class="contact-status">
                                <div class="online"></div>
                                <div class="status">online</div>
                            </div>
                            <div class="last-chat-time">
                                a moment ago
                            </div>
                            <div class="back">
                                <i class="fa fa-arrow-circle-left"></i>
                            </div>
                        </div>
                    </div>
                    <ul class="messages-list">
                        <li class="message">
                            <div class="message-info">
                                <div class="bullet"></div>
                                <div class="contact-name">Me</div>
                                <div class="message-time">10:14 AM, Today</div>
                            </div>
                            <div class="message-body">
                                Hi, Hope all is good. Are we meeting today?
                            </div>
                        </li>
                        <li class="message reply">
                            <div class="message-info">
                                <div class="bullet"></div>
                                <div class="contact-name">Divyia</div>
                                <div class="message-time">10:15 AM, Today</div>
                            </div>
                            <div class="message-body">
                                Hi, Hope all is good. Are we meeting today?
                            </div>
                        </li>
                        <li class="message">
                            <div class="message-info">
                                <div class="bullet"></div>
                                <div class="contact-name">Me</div>
                                <div class="message-time">10:14 AM, Today</div>
                            </div>
                            <div class="message-body">
                                Hi, Hope all is good. Are we meeting today?
                            </div>
                        </li>
                        <li class="message reply">
                            <div class="message-info">
                                <div class="bullet"></div>
                                <div class="contact-name">Divyia</div>
                                <div class="message-time">10:15 AM, Today</div>
                            </div>
                            <div class="message-body">
                                Hi, Hope all is good. Are we meeting today?
                            </div>
                        </li>
                        <li class="message">
                            <div class="message-info">
                                <div class="bullet"></div>
                                <div class="contact-name">Me</div>
                                <div class="message-time">10:14 AM, Today</div>
                            </div>
                            <div class="message-body">
                                Hi, Hope all is good. Are we meeting today?
                            </div>
                        </li>
                        <li class="message reply">
                            <div class="message-info">
                                <div class="bullet"></div>
                                <div class="contact-name">Divyia</div>
                                <div class="message-time">10:15 AM, Today</div>
                            </div>
                            <div class="message-body">
                                Hi, Hope all is good. Are we meeting today?
                            </div>
                        </li>
                    </ul>
                    <div class="send-message">
                        <span class="input-icon icon-right">
                            <textarea rows="4" class="form-control" placeholder="Type your message"></textarea>
                            <i class="fa fa-camera themeprimary"></i>
                        </span>
                    </div>
                </div>
            </div>
            <!-- /Chat Bar -->
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="#">Home</a>
                        </li>
                        <li class="active">Catálogo</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <!-- /Page Header -->
                <!-- Page Body -->
                <div id="box-container" class="page-body">
                    <div class="box-filters">
                        <select name="cbocategoria" id="cbocategoria" class="form-control m-b-10" onchange="cargarmarcas();" >
                        	<option value="0">- Categorias -</option>
				        	<c:forEach var="categoria" items="${listacategorias}">
				        		<option value="${ categoria.idcategoria }">${ categoria.nombre }</option>
				        	</c:forEach>            	
				        </select>
                        <select name="itemmarca" id="cbomarca" class="form-control m-b-10" >
                            <option value="0">- Marcas -</option>
                        </select>
                        <select name="itemmodelo" class="form-control m-b-10" >
                            <option value="0">- Modelos -</option>
                            <option value="1">Modelo 2</option>
                            <option value="1">Modelo 3</option>
                            <option value="1">Modelo 4</option>
                            <option value="1">Modelo 5</option>
                        </select>
                        <input type="text" name="txtfilterprod" class="form-control m-b-10" placeholder="Buscar" style="float: right;" />
                    </div>
                    <div class="block-area">
                    <div id="photo-gallery-alt">
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="javascript:void(0);">
                                <img src="assets/photo-gallery/superbox-thumb-1.jpg" alt="Sample Image Title">
                                <span class="box-details">
                                    <label>Quicksilver</label>
                                    <label>MD5102 - QT</label>
                                    <label>Azul</label>
                                    <div class="precio">
                                        <input type="text" name="txtpreciofinal" class="form-control input-sm m-b-10" placeholder="0" value="225.00" />
                                    </div>
                                    <div class="box-cantidad">
                                        <input type="text" placeholder="Cantidad" class="form-control input-sm m-b-10" value="1" />
                                        <input type="button" value="Agregar" />
                                    </div>
                                </span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-2.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-2.jpg" alt="Sample Image Title 2">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-3.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-3.jpg" alt="Sample Image Title 3">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-4.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-4.jpg" alt="Sample Image Title 4">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-5.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-5.jpg" alt="Sample Image Title 5">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-6.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-6.jpg" alt="Sample Image Title 6">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-7.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-7.jpg" alt="Sample Image Title 7">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-8.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-8.jpg" alt="Sample Image Title 8">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-9.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-9.jpg" alt="Sample Image Title 9">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-10.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-10.jpg" alt="Sample Image Title 10">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-11.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-11.jpg" alt="Sample Image Title 11">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-12.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-12.jpg" alt="Sample Image Title 12">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-13.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-13.jpg" alt="Sample Image Title 13">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-14.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-14.jpg" alt="Sample Image Title 14">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-15.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-15.jpg" alt="Sample Image Title 15">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-16.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-16.jpg" alt="Sample Image Title 16">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-17.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-17.jpg" alt="Sample Image Title 17">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-18.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-18.jpg" alt="Sample Image Title 18">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-19.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-19.jpg" alt="Sample Image Title 19">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-20.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-20.jpg" alt="Sample Image Title 20">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-21.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-21.jpg" alt="Sample Image Title 21">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-22.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-22.jpg" alt="Sample Image Title 22">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-23.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-23.jpg" alt="Sample Image Title 23">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                        <div class="gallery-item col-md-3 col-sm-3 col-xs-4">
                            <a href="assets/photo-gallery/superbox-full-24.jpg">
                                <img src="assets/photo-gallery/superbox-thumb-24.jpg" alt="Sample Image Title 24">
                                <span><i class="fa fa-search"></i></span>
                            </a>
                        </div>
                    </div>                    
                </div>                
                </div>
                <!-- /Page Body -->
                
            </div>
            <!-- /Page Content -->

        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>

    <!--Basic Scripts-->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/slimscroll/jquery.slimscroll.min.js"></script>

    <!--Beyond Scripts-->
    <script src="assets/js/beyond.js"></script>
    <script src="assets/js/ventas.js"></script>
    <script src="assets/js/modules/catalogo.js"></script>
    <script src="assets/js/modules/compras.js"></script>
    <script src="assets/js/modules/configuracion.js"></script>
    <script src="assets/js/modules/seguridad.js"></script>

    <!--Page Related Scripts-->
    <!--Sparkline Charts Needed Scripts-->
    <script src="assets/js/charts/sparkline/jquery.sparkline.js"></script>
    <script src="assets/js/charts/sparkline/sparkline-init.js"></script>

    <!--Easy Pie Charts Needed Scripts-->
    <script src="assets/js/charts/easypiechart/jquery.easypiechart.js"></script>
    <script src="assets/js/charts/easypiechart/easypiechart-init.js"></script>

    <!--Flot Charts Needed Scripts-->
    <script src="assets/js/charts/flot/jquery.flot.js"></script>
    <script src="assets/js/charts/flot/jquery.flot.resize.js"></script>
    <script src="assets/js/charts/flot/jquery.flot.pie.js"></script>
    <script src="assets/js/charts/flot/jquery.flot.tooltip.js"></script>
    <script src="assets/js/charts/flot/jquery.flot.orderBars.js"></script>

    <script>
        // If you want to draw your charts with Theme colors you must run initiating charts after that current skin is loaded
        $(window).bind("load", function () {

            /*Sets Themed Colors Based on Themes*/
            themeprimary = getThemeColorFromCss('themeprimary');
            themesecondary = getThemeColorFromCss('themesecondary');
            themethirdcolor = getThemeColorFromCss('themethirdcolor');
            themefourthcolor = getThemeColorFromCss('themefourthcolor');
            themefifthcolor = getThemeColorFromCss('themefifthcolor');

            //Sets The Hidden Chart Width
            $('#dashboard-bandwidth-chart')
                .data('width', $('.box-tabbs')
                    .width() - 20);

            //-------------------------Visitor Sources Pie Chart----------------------------------------//
            var data = [
                {
                    data: [[1, 21]],
                    color: '#fb6e52'
                },
                {
                    data: [[1, 12]],
                    color: '#e75b8d'
                },
                {
                    data: [[1, 11]],
                    color: '#a0d468'
                },
                {
                    data: [[1, 10]],
                    color: '#ffce55'
                },
                {
                    data: [[1, 46]],
                    color: '#5db2ff'
                }
            ];
            var placeholder = $("#dashboard-pie-chart-sources");
            placeholder.unbind();

            $.plot(placeholder, data, {
                series: {
                    pie: {
                        innerRadius: 0.45,
                        show: true,
                        stroke: {
                            width: 4
                        }
                    }
                }
            });

            //------------------------------Visit Chart------------------------------------------------//
            var data2 = [{
                color: themesecondary,
                label: "Direct Visits",
                data: [[3, 2], [4, 5], [5, 4], [6, 11], [7, 12], [8, 11], [9, 8], [10, 14], [11, 12], [12, 16], [13, 9],
                [14, 10], [15, 14], [16, 15], [17, 9]],

                lines: {
                    show: true,
                    fill: true,
                    lineWidth: .1,
                    fillColor: {
                        colors: [{
                            opacity: 0
                        }, {
                            opacity: 0.4
                        }]
                    }
                },
                points: {
                    show: false
                },
                shadowSize: 0
            },
                {
                    color: themeprimary,
                    label: "Referral Visits",
                    data: [[3, 10], [4, 13], [5, 12], [6, 16], [7, 19], [8, 19], [9, 24], [10, 19], [11, 18], [12, 21], [13, 17],
                    [14, 14], [15, 12], [16, 14], [17, 15]],
                    bars: {
                        order: 1,
                        show: true,
                        borderWidth: 0,
                        barWidth: 0.4,
                        lineWidth: .5,
                        fillColor: {
                            colors: [{
                                opacity: 0.4
                            }, {
                                opacity: 1
                            }]
                        }
                    }
                },
                {
                    color: themethirdcolor,
                    label: "Search Engines",
                    data: [[3, 14], [4, 11], [5, 10], [6, 9], [7, 5], [8, 8], [9, 5], [10, 6], [11, 4], [12, 7], [13, 4],
                    [14, 3], [15, 4], [16, 6], [17, 4]],
                    lines: {
                        show: true,
                        fill: false,
                        fillColor: {
                            colors: [{
                                opacity: 0.3
                            }, {
                                opacity: 0
                            }]
                        }
                    },
                    points: {
                        show: true
                    }
                }
            ];
            var options = {
                legend: {
                    show: false
                },
                xaxis: {
                    tickDecimals: 0,
                    color: '#f3f3f3'
                },
                yaxis: {
                    min: 0,
                    color: '#f3f3f3',
                    tickFormatter: function (val, axis) {
                        return "";
                    },
                },
                grid: {
                    hoverable: true,
                    clickable: false,
                    borderWidth: 0,
                    aboveData: false,
                    color: '#fbfbfb'

                },
                tooltip: true,
                tooltipOpts: {
                    defaultTheme: false,
                    content: " <b>%x May</b> , <b>%s</b> : <span>%y</span>",
                }
            };
            var placeholder = $("#dashboard-chart-visits");
            var plot = $.plot(placeholder, data2, options);

            //------------------------------Real-Time Chart-------------------------------------------//
            var realTimedata = [],
                realTimedata2 = [],
                totalPoints = 300;

            var getSeriesObj = function () {
                return [
                {
                    data: getRandomData(),
                    lines: {
                        show: true,
                        lineWidth: 1,
                        fill: true,
                        fillColor: {
                            colors: [
                                {
                                    opacity: 0
                                }, {
                                    opacity: 1
                                }
                            ]
                        },
                        steps: false
                    },
                    shadowSize: 0
                }, {
                    data: getRandomData2(),
                    lines: {
                        lineWidth: 0,
                        fill: true,
                        fillColor: {
                            colors: [
                                {
                                    opacity: .5
                                }, {
                                    opacity: 1
                                }
                            ]
                        },
                        steps: false
                    },
                    shadowSize: 0
                }
                ];
            };
            function getRandomData() {
                if (realTimedata.length > 0)
                    realTimedata = realTimedata.slice(1);

                // Do a random walk

                while (realTimedata.length < totalPoints) {

                    var prev = realTimedata.length > 0 ? realTimedata[realTimedata.length - 1] : 50,
                        y = prev + Math.random() * 10 - 5;

                    if (y < 0) {
                        y = 0;
                    } else if (y > 100) {
                        y = 100;
                    }
                    realTimedata.push(y);
                }

                // Zip the generated y values with the x values

                var res = [];
                for (var i = 0; i < realTimedata.length; ++i) {
                    res.push([i, realTimedata[i]]);
                }

                return res;
            }
            function getRandomData2() {
                if (realTimedata2.length > 0)
                    realTimedata2 = realTimedata2.slice(1);

                // Do a random walk

                while (realTimedata2.length < totalPoints) {

                    var prev = realTimedata2.length > 0 ? realTimedata[realTimedata2.length] : 50,
                        y = prev - 25;

                    if (y < 0) {
                        y = 0;
                    } else if (y > 100) {
                        y = 100;
                    }
                    realTimedata2.push(y);
                }


                var res = [];
                for (var i = 0; i < realTimedata2.length; ++i) {
                    res.push([i, realTimedata2[i]]);
                }

                return res;
            }
            // Set up the control widget
            var updateInterval = 500;
            var plot = $.plot("#dashboard-chart-realtime", getSeriesObj(), {
                yaxis: {
                    color: '#f3f3f3',
                    min: 0,
                    max: 100,
                    tickFormatter: function (val, axis) {
                        return "";
                    }
                },
                xaxis: {
                    color: '#f3f3f3',
                    min: 0,
                    max: 100,
                    tickFormatter: function (val, axis) {
                        return "";
                    }
                },
                grid: {
                    hoverable: true,
                    clickable: false,
                    borderWidth: 0,
                    aboveData: false
                },
                colors: ['#eee', themeprimary],
            });

            function update() {

                plot.setData(getSeriesObj());

                plot.draw();
                setTimeout(update, updateInterval);
            }
            update();


            //-------------------------Initiates Easy Pie Chart instances in page--------------------//
            InitiateEasyPieChart.init();

            //-------------------------Initiates Sparkline Chart instances in page------------------//
            InitiateSparklineCharts.init();
        });

    </script>
</body>
</html>