<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/bill/billmodifysave">
			<input type="hidden" name="id" value="${bill.id }"/>
			 <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value="${bill.productName }">
					<font color="red"></font>
             </div>
			 <div>
                    <label >是否支付：</label>
                    <select name="isPayment" id="isPayment">
						<c:choose>
							<c:when test="${bill.isPayment == 1 }">
								<option value="1" selected="selected">未支付</option>
					    		<option value="2">已支付</option>
							</c:when>
							<c:otherwise>
								<option value="1">未支付</option>
					    		<option value="2" selected="selected">已支付</option>
							</c:otherwise>
						</c:choose>
					 </select>
             </div>
			 <div>
					 <label for="productDesc">商品描述：</label>
					 <input type="text" name="productDesc" id="productDesc" value="${bill.productDesc }">
					 <font color="red"></font>
              </div>
			
		       <div>
                    <label for="productUnit">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value="${bill.productUnit }">
                    <font color="red"></font>
               </div>
                <div>
                    <label for="productCount">商品数量：</label>
                    <input type="text" name="productCount" id="productCount" value="${bill.productCount }">
                </div>
			<div>
				<label for="totalPrice">商品总额：</label>
				<input type="text" name="totalPrice" id="totalPrice" value="${bill.totalPrice }">
			</div>
			 <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billmodify.js"></script>
