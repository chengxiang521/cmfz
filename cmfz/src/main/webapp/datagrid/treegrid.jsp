<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <script type="text/javascript">
$(function () {
    $('#albumtb').treegrid({
        url:"${pageContext.request.contextPath}/album/all",
        idField:'id',
        treeField:'title',
        fitColumns : true,
        fit:true,
        toolbar:"#albumdiv",
        columns:[[
            {field:'title',title:'名字',width:100},
            {field:'chpath',title:'下载路径',width:100},
            {field:'size',title:'章节大小',width:100},
            {field:'duration',title:'章节时长',width:100}
        ]],
        onDblClickRow:function (row) {
            var row = $("#albumtb").treegrid("getSelected");
            if(row.size!=null){
                var player = $("#audi")[0]; /*jquery对象转换成js对象*/
                if (player.paused){ /*如果已经暂停*/
                    $("#audi").prop("src","${pageContext.request.contextPath}/upload"+row.chpath);
                    player.play(); /*播放*/
                }else {
                    player.pause();/*暂停*/
                }
            }
        }
    });
    $("#albumadd").linkbutton({
        iconCls:"icon-help",
        onClick:function () {
            //获取选中行
            var row = $("#albumtb").treegrid("getSelected");
            if(row!=null){
                if(row.size!=null){
                    $.messager.show({
                        title : "警告",
                        msg : "请选择专辑"
                    });
                }else{
                    $("#albumtbaddiv").dialog("open");
                    var id=row.id;
                    $('#albumfor').form('load',"${pageContext.request.contextPath}/album/one?id="+id);
                }
            }else {
                $.messager.show({
                    title : "警告",
                    msg : "请选择要查看的行"
                });
            }
        }
    });
    $("#albumup").linkbutton({
        iconCls:"icon-add",
        onClick:function () {
            $("#albumtbaddiv1").dialog("open");

        }
    });
    $("#albumdel").linkbutton({
        iconCls:"icon-add",
        onClick:function () {
            //获取选中行
            var row = $("#albumtb").treegrid("getSelected");
            if(row!=null){
                    if(row.size!=null){
                        $.messager.show({
                            title : "警告",
                            msg : "请选择专辑"
                        });
                    }else {
                        $("#albumtbaddiv2").dialog("open");
                        $("#albumid").val(row.id);
                    }
            }else{
                $.messager.show({
                    title : "警告",
                    msg : "请选择专辑"
                });
            }
        }

    });
    $("#albumsave").linkbutton({
        iconCls:"icon-reload",
        onClick:function () {
            //获取选中行
            var row = $("#albumtb").treegrid("getSelected");
            if(row.size!=null){
                window.location.href="${pageContext.request.contextPath}/chapt/down?name="+row.chpath;
            }else {
                $.messager.show({
                    title : "警告",
                    msg : "请选择音频"
                });
            }
        }
    });
    $("#albumtbaddiv").dialog({
    title: 'My Dialog',
    width: 400,
    height: 200,
    closed: true,
    cache: false,
    modal: true
    });
    $("#albumtbaddiv1").dialog({
        title: 'My Dialog',
        width: 400,
        height: 200,
        closed: true,
        cache: false,
        modal: true
    });
    $("#albumtbaddiv2").dialog({
        title: 'My Dialog',
        width: 400,
        height: 200,
        closed: true,
        cache: false,
        modal: true
    });

$("#albumcz").linkbutton({
    onClick:function () {
        $("#albumfor1").form("reset");
    }
});
    $("#albumtj").linkbutton({
        onClick:function () {
            $("#albumfor1").form("submit", {
                url : "${pageContext.request.contextPath}/album/add",
                onSubmit : function() {
                    return $("#albumfor1").form("validate");
                },
                success : function() {
                    $.messager.show({
                        title : "标题",
                        msg : "保存成功"
                    });
                    $("#albumtb").treegrid("load");
                }
            });
            $("#albumtbaddiv1").dialog("close");
        }
    });
    $("#albumcz2").linkbutton({
        onClick:function () {
            $("#albumfor2").form("reset");
        }
    });
    $("#albumtj2").linkbutton({
        onClick:function () {
                    $("#albumfor2").form("submit", {
                        url : "${pageContext.request.contextPath}/chapt/add",
                        onSubmit : function() {
                            return $("#albumfor2").form("validate");
                        },
                        success : function() {
                            $.messager.show({
                                title : "标题",
                                msg : "保存成功"
                            });
                            $("#albumtb").treegrid("load");
                        }
                    });
                    $("#albumtbaddiv2").dialog("close");
        }
    });
})

    </script>


<table id="albumtb"></table>

<div id="albumdiv">
    <a id="albumadd">专辑详情</a>
    <a id="albumup">专辑添加</a>
    <a id="albumdel">添加章节</a>
    <a id="albumsave">下载音频</a>
</div>
<div id="albumtbaddiv">
    <form id="albumfor" method="post">
        专辑名称： <input name="title" /><br>
        音频数量：<input name="count" /><br>
        头像路径：<input name="coverimg" /><br>
        评分：<input name="score" /><br>
        作者：<input name="author"/><br>
        播音：<input name="broadcast" /><br>
        简介：<input name="brief"/><br>
        上架日期：<input name="pubdate"/><br>
    </form>
</div>
<div id="albumtbaddiv1">
    <form id="albumfor1" method="post" enctype="multipart/form-data">
        专辑名称： <input name="title" /><br>
        头像路径：<input type="file"  name="srcpath"/><br/>
        评分：<input name="score" /><br>
        作者：<input name="author"/><br>
        播音：<input name="broadcast" /><br>
        简介：<input name="brief"/><br>
        <a id="albumtj">提交</a> <a id="albumcz">重置</a>
    </form>
</div>
<div id="albumtbaddiv2">
    <form id="albumfor2" method="post" enctype="multipart/form-data">
        音频名称： <input name="title" /><br>
        音频路径：<input type="file"  name="srcpath"/><br/>
        <input id="albumid"  name="albumid"  hidden/><br>
        <a id="albumtj2">提交</a> <a id="albumcz2">重置</a>
    </form>
</div>
<audio  id="audi" autoplay="autoplay"  controls='controls'/>
