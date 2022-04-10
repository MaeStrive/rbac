layui.use(['table', 'layer', 'form'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    //渲染表格数据
    table.render({
        elem: "#dataTable",
        url: "/roles/list",
        page: true,
        cols: [[
            {title: 'ID', field: 'id', width: '5'},
            {title: '名称', field: 'name', width: '20%'},
        ]]
    });
    //查询
    $("#searchBtn").on('click', function () {
        table.render({
            elem: "#dataTable",
            url: "/roles/list",
            page: true,
            cols: [[
                {title: 'ID', field: 'id', width: '5%'},
                {title: '姓名', field: 'name', width: '20%'},
                {title: '操作', width: '25%', toolbar: "#operateTemplate"}
            ]]
        });
    }).click();
});