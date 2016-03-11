var sDialog;
var uDialog;
var grid;
var param = {};
var editData = {};
$(function(){
	param.phone = $("#q_phone").val();
	param.interceptNumber = $("#q_interceptNumber").val();
	/** 初始化表格* */
	grid = $("#maingrid").ligerGrid({
		columns : [{
			name : 'phone',
			display : '手机号码'
		},{
			name : 'interceptNumber',
			display : '拦截号码'
		},{
			name : 'interceptContent',
			display : '拦截内容',
			width:'500'
		},{
			name : 'interceptTime',
			display : '拦截时间'
		}
		],
		url : basePath + "/findInterceptRecordPage.do",
		parms:[{
			name : "phone",
			value : param.phone
			},
			{
			name : "interceptNumber",
			value : param.interceptNumber
			}],
		root : "rows",
		record:'total',
		pageSize:15,
		pageSizeOptions: [5, 15, 30, 50],
		usePager : true,
		enabledSort : false,
		checkbox : true
	});
});

/** 打开保存窗口* */
function saveDialog() {
	$("#id").val("");
	$("#number").val("");
	sDialog = $.ligerDialog.open({
		name : "add",
		target : $("#editDialog"),
		height : 250,
		width : 400,
		title : "添加",
		buttons : [ {
			text : '确定',
			onclick : function(item, dialog) {
				save();
			}
		}, {
			text : '取消',
			onclick : function(item, dialog) {
				dialog.hide();
			}
		} ]
	});
}

/** 打开修改窗口* */
function updateDialog() {
	var rows = grid.getSelecteds();
	if (rows.length == 1) {
		editData = rows[0];
		$("#id").val(editData.id);
		$("#number").val(editData.number);
		uDialog = $.ligerDialog.open({
			name : "upd",
			target : $("#editDialog"),
			height : 250,
			width : 400,
			title : "修改",
			buttons : [ {
				text : '确定',
				onclick : function(item, dialog) {
					update();
				}
			}, {
				text : '取消',
				onclick : function(item, dialog) {
					dialog.hide();
				}
			} ]
		});
	} else if (rows.length == 0) {
		$.ligerDialog.warn('请选择数据!');
	} else if (rows.length > 1) {
		$.ligerDialog.warn('请仅选择一条数据!');
	}
}

function save(){
	var param = {};
	param.number = $("#number").val();
	if(validate(param)){
		$.ajax({
			type:"post",//请求方式
	 		url:basePath + "/addInterceptRecord.do",//发送请求地址
	 		data:param,
	 	 	//请求成功后的回调函数有两个参数
	 	 	success:function(data,textStatus){
			   if(data==""){
				   $.ligerDialog.success('保存成功!',"",function(){gridRefresh();sDialog.hide();});
			   }else{
				   $.ligerDialog.error('保存失败!'+data);
			   }
	  	  	},error:function(data,textStatus){
	  	  		$.ligerDialog.error('保存失败!');
	  	  	}
		});
	}
}

function update(){
	var param = {};
	param.id = $("#id").val();
	param.number = $("#number").val();
	if(validate(param)){
		$.ajax({
			type:"post",//请求方式
	 		url:basePath + "/updateInterceptRecord.do",//发送请求地址
	 		data:param,
	 	 	//请求成功后的回调函数有两个参数
	 	 	success:function(data,textStatus){
			   if(data==""){
				   $.ligerDialog.success('修改成功!',"",function(){gridRefresh();uDialog.hide();});
			   }else{
				   $.ligerDialog.error('修改失败!'+data);
			   }
	  	  	},error:function(data,textStatus){
	  	  		$.ligerDialog.error('修改失败!');
	  	  	}
		});
	}
}

/** 删除* */
function del() {
	var rows = grid.getSelecteds();
	if (rows.length > 0) {
		$.ligerDialog.confirm('删除后数据无法恢复，确定删除？', function(yes) {
			if (yes) {
				$.ajax({
					type : "post",// 请求方式
					url : basePath + "/deleteInterceptRecord.do",// 发送请求地址
					data : {// 发送给数据库的数据
						json : $.toJSON(rows)
					},
					// 请求成功后的回调函数有两个参数
					success : function(data, textStatus) {
						$.ligerDialog.success('删除成功!');
						gridRefresh();
					},
					error : function(data, textStatus) {
						$.ligerDialog.error('删除失败!');
					}
				});
			}
		});
	} else {
		$.ligerDialog.warn('请选择数据!');
	}
}

function gridRefresh() {
	if (grid) {
		var gridparms = [];
		// grid.options.parms[1].value = "{}";
		gridparms.push({
			name : "funcid",
			value : "getprimary"
		});
		gridparms.push({
			name : "phone",
			value : $("#q_phone").val()
		},{
			name : "interceptNumber",
			value : $("#q_interceptNumber").val()
		},{
			name : "startTime",
			value : $("#startTime").val()
		},{
			name : "endTime",
			value : $("#endTime").val()
		});
		gridparms.push({
			name : "page",
			value : 1
		});
		gridparms.push({
			name : "pagesize",
			value : grid.options.pageSize
		});
		grid.loadServerData(gridparms);
	}
}


/** 验证* */
function validate(param) {
	if (param.number == null || param.number == "") {
		$.ligerDialog.warn('拦截号码不能为空！');
		return false;
	}
	return true;
}
