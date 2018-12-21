<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">

    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#dgbanner').edatagrid({
                url:"${pageContext.request.contextPath}/banner/all",
                updateUrl:"${pageContext.request.contextPath}/banner/all",
                columns:[[
                    {field:'title',title:'名字',width:100},
                    {field:'stauts',title:'状态',width:100, editor: {
                            type: "text",
                            options: {required:true}
                        }},
                    {field:'imgpath',title:'路径',width:100},
                    {field:'uploaddate',title:'时间',width:100}
                ]],
                fitColumns : true,
                toolbar : "#dgbannertb",
                view: detailview,
                detailFormatter: function(rowIndex, rowData){

                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgpath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>描述: ' + rowData.descriptlon + '</p>' +
                        '<p>状态: ' + rowData.stauts + '</p>' +
                        '<p>路径: ' + rowData.imgpath + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
            $("#bannerad").linkbutton({
                iconCls:"icon-add"
            });
            $("#bannerup").linkbutton({
                iconCls:"icon-edit",
                onClick:function () {
                    //获取选中行
                    var row = $("#dgbanner").edatagrid("getSelected");
                    if (row != null) {
                        //编辑指定行
                        var index = $("#dgbanner").edatagrid("getRowIndex", row);
                        $("#dgbanner").edatagrid("editRow", index);
                    } else {
                        $.messager.show({
                            title : "提示",
                            msg : "请先选中要修改的行"
                        });
                    }

                }
            });
            $("#bannerde").linkbutton({
                iconCls:"icon-remove"
            });
            $("#bannersa").linkbutton({
                iconCls:"icon-save",
                onClick:function () {
                    $('#dgbanner').edatagrid("saveRow");
                }
            });
        })

    </script>

</head>
<body>

<table id="dgbanner"></table>

</body>
<div id="dgbannertb">
    <a id="bannerad">添加</a>
    <a id="bannerup">修改</a>
    <a id="bannerde">删除</a>
    <a id="bannersa">保存</a>
</div>
</html>