<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 登录的弹出框 -->
<!-- Button trigger modal -->
<!-- Modal -->
<div class="modal fade" id="staticModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">用户登录</h4>
			</div>
			<div class="modal-body">
				<form id="postform" class="form-horizontal" role="form">
					<div class="form-group" id="namebox">
						<label for="text3" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nameinput"
								name="user.uname" placeholder="请输入用户名">
							<span style="color:red"></span>
						</div>
					</div>
					<div class="form-group" id="pwdbox">
						<label for="text3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pwdinput"
								name="user.pwd" placeholder="请输入密码">
							<span style="color:red"></span>
						</div>
					</div>
					
					<div class="form-group" id="phonebox">
						<label for="inputPassword3" class="col-sm-2 control-label">手机号</label>
						<div class="col-sm-10">
							<input name="user.phone" id="phoneinput" type="tel" class="form-control" 
								placeholder="请输入手机号">
								<span style="color:red"></span>
						</div>
					</div>
					<div class="form-group" id="birthbox">
						<label for="inputPassword3" class="col-sm-2 control-label">生日</label>
						<div class="col-sm-10">
							<input name="user.birth" type="date" class="form-control" />
						</div>
					</div>
					
					<div class="form-group" id="verimgbox">
						<label for="text3" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="authImg" id="yzm" maxlength=6
								placeholder="请输入验证码，单击图片可刷新">
								 <br /> 
								<img src="auth_authImg" alt="验证码" height="25"
								align="bottom" style="cursor: pointer;" title="看不清可单击图片刷新"
								onclick="this.src='auth_authImg?d='+Math.random();" />
								<span style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox">记住我
								</label>
							</div>
						</div>
					</div>

				</form>
			</div>

			<div class="modal-footer">
				<button id="ok" type="button" class="btn btn-success">登录</button>
				<!--data-dismiss="modal"  -->
				<button id="cancel" type="button"
					class="btn btn-default" data-dismiss="modal" >取消</button>
			</div>
			
		</div>
	</div>
</div>

