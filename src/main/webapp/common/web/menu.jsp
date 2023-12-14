<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý học viên
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/trang-chu/danh-sach-hoc-vien?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Học viên
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/trang-chu/danh-sach-giao-vien?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                       Giáo viên
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/trang-chu/danh-sach-lop?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Lớp
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/trang-chu/danh-sach-khoa?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Khoa
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            
        </li>
    </ul>
   	
</div>