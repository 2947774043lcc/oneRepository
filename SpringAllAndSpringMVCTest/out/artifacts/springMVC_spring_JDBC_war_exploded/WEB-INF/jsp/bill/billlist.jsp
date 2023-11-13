<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>订单管理页面</span>
            </div>
            <div class="search">
           		<form method="post" action="${pageContext.request.contextPath }/bill/billlist">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>订单编码：</span>
					 <input name="billCode" class="input-text"	type="text" value="${billCode }">

					<span>订单名称：</span>
					<input name="productName" type="text" value="${productName }">
					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${pageContext.request.contextPath}/bill/billadd">添加订单</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">账单编码</th>
                    <th width="20%">商品名称</th>
                    <th width="10%">商品描述</th>
                    <th width="10%">商品单位</th>
                    <th width="10%">商品数量</th>
                    <th width="10%">商品总额</th>
                    <th width="30%">操作</th>
                </tr>
                   <c:forEach var="bill" items="${billList}" varStatus="status">
					<tr>
						<td>
						<span>${bill.billCode }</span>
						</td>
						<td>
						<span>${bill.productName }</span>
						</td>
						<td>
						<span>${bill.productDesc }</span>
						</td>
						<td>
						<span>${bill.productUnit}</span>
						</td>
						<td>
						<span>${bill.productCount}</span>
						</td>
						<td>
						<span>${bill.totalPrice}</span>
						</td>
						<td>
							<span><a class="viewBill" href="javascript:;" billid="${bill.id }" productName="${bill.productName}"><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
							<span><a class="modifyBill" href="javascript:;" billid="${bill.id }" productName="${bill.productName}"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
							<span><a class="deletebill"  href="${pageContext.request.contextPath }/bill/deletebill?billid=${bill.id}" billid="${bill.id }" productName="${bill.productName}"><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="../rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billlist.js"></script>
