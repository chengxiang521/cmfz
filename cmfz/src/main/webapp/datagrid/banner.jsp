<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <script type="text/javascript">

        $(function () {

            $('#dgbanner').edatagrid({
                url:"${pageContext.request.contextPath}/banner/all",
                updateUrl:"${pageContext.request.contextPath}/banner/update",
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
                fit:true,
                toolbar : "#dgbannertb",
                pagination: true,
                pageList: [1, 3, 5, 7, 9],
                pageSize: 3,
                view: detailview,
                detailFormatter: function(rowIndex, rowData){

                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgpath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>描述: ' + rowData.descriptlon + '</p>' +
                        '<p>状态: ' + rowData.stauts + '</p>' +
                        '<p>路径: ' + rowData.imgpath + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
            $("#bannerad").linkbutton({
                iconCls:"icon-add",
                onClick : function() {
                    $("#banneradddiv").dialog({
                        closed : false
                    });
                }
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
                        $.messager.show({
                            title : "成功",
                            msg : "修改成功"
                        });
                    } else {
                        $.messager.show({
                            title : "提示",
                            msg : "请先选中要修改的行"
                        });
                    }

                }
            });
            $("#bannerde").linkbutton({
                iconCls:"icon-remove",
                onClick:function () {
                    //获取选中行
                    var row = $("#dgbanner").edatagrid("getSelected");
                    var id=row.id;
                    if (row != null) {
                        //删除
                        $.ajax({
                            type:"POST",
                            url:"${pageContext.request.contextPath}/banner/del",
                            data:"id="+id,
                            success:function () {

                                $.messager.show({
                                    title : "成功",
                                    msg : "删除成功"
                                });
                                $("#dgbanner").edatagrid("reload");
                            }

                        })
                         $("#dgbanner").edatagrid("destroyRow", index);

                    } else {
                        $.messager.show({
                            title : "提示",
                            msg : "请先选中要删除的行"
                        });
                    }

                }
            });
            $("#bannersa").linkbutton({
                iconCls:"icon-save",
                onClick:function () {
                    $('#dgbanner').edatagrid("saveRow");
                    $.messager.show({
                        title : "保存",
                        msg : "保存成功"
                    });
                  //  $("#dgbanner").edatagrid("load");
                }
            });
            $("#banneradddiv").dialog({
                method: "GET",
                closed : true,
                modal : true,
                title : "增加一个对象",
                iconCls : "icon-add",
                width : 300,
                height : 400,
                href : "${pageContext.request.contextPath}/datagrid/addbanner.jsp"
            });
        })

    </script>


<table id="dgbanner"></table>

<div id="dgbannertb">
    <a id="bannerad">添加</a>
    <a id="bannerup">修改</a>
    <a id="bannerde">删除</a>
    <a id="bannersa">保存</a>
</div>
<div id="banneradddiv"></div>
