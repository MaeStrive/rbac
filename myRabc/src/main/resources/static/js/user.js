layui.use(['table', 'layer', 'form'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    //渲染表格数据
    table.render({
        elem: "#dataTable",
        url: "/users/list",
        page: true,
        cols: [[
            {title: 'ID', field: 'id', width: '20%'},
            {title: '用户名', field: 'username', width: '20%'},
            {title: '姓名', field: 'name', width: '20%'},
            {title: '性别', field: 'sex', width: '20%'},
            {title: '年龄', field: 'age', width: '20%'},
            {title: '地址', field: 'address', width: '20%'}
        ]]
    });
    //查询
    $("#searchBtn").on('click', function () {
        table.render({
            elem: "#dataTable",
            url: "/users/list",
            where: {keyword: $("#keyword").val()},
            page: true,
            cols: [[
                {title: 'ID', field: 'id', width: '5%'},
                {title: '用户名', field: 'username', width: '20%'},
                {title: '姓名', field: 'name', width: '20%'},
                {title: '性别', field: 'sex', width: '5%'},
                {title: '年龄', field: 'age', width: '5%'},
                {title: '地址', field: 'address', width: '20%'},
                {title: '操作', width: '25%', toolbar: "#operateTemplate"}
            ]]
        });
    }).click();

    //绑定表格工具条事件
    table.on('tool', function (obj) {
        console.log(obj);
        if (obj.event === 'del') {
            layer.confirm('您确定要删除这个用户吗?', function () {
                //点击了删除按钮
                //请求后台删除用户
                $.post('/users/del', {id: obj.data.id}, function () {
                    $("#searchBtn").click();
                    layer.closeAll();
                })
                //取消窗口已经内置 关窗
            }, function () {
            });
        } else if (obj.event === 'edit') {
            //点击了编辑按钮
            $.get('/users/info', {id: obj.data.id}, function (data) {
                layer.open({
                    type: 1,
                    area: ['400px', '450px'],
                    title: '编辑用户',
                    content: $("#addTemplate").html()
                });
                form.val('userForm', data);
                form.render();
                $("#saveBtn").on('click', function () {
                    //1、获取表单中所有数据
                    var d = form.val('userForm');
                    console.log(d)
                    //2、数据传递给controller ajax异步请求
                    $.post('/users/save', d, function () {
                        //关闭窗口
                        layer.closeAll();
                        //刷新表格
                        $("#searchBtn").click();
                    });
                    //3、关闭窗口
                    layer.closeAll();
                    //4、刷新一遍表格数据
                    $("#searchBtn").click();
                })
            })
        } else if (obj.event === 'role') {
            //点击了角色按钮

        }
    });

    //新增
    $("#addBtn").on('click', function () {
        layer.open({
            type: 1,
            area: ['400px', '450px'],
            title: '新增用户',
            content: $("#addTemplate").html()
        });
        form.render();

        $("#saveBtn").on('click', function () {
            //1、获取表单中所有数据
            var d = form.val('userForm');
            console.log(d)
            //2、数据传递给controller ajax异步请求
            $.post('/users/save', d, function () {
                //关闭窗口
                layer.closeAll();
                //刷新表格
                $("#searchBtn").click();
            });
            //3、关闭窗口
            layer.closeAll();
            //4、刷新一遍表格数据
            $("#searchBtn").click();
        })
    });


});
