<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
        <!-- 제목을 뮤직스타일 -->
        <title>뮤직스타일</title>
        <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../node_modules/@fortawesome/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="../css&js/common/common.css">
        <link rel="stylesheet" type="text/css" href="../css&js/information/information.css">
        <script src="../node_modules/jquery/dist/jquery.min.js"></script>


        <script>
        function getInternetExplorerVersion(){
            var e=-1;
            if("Microsoft Internet Explorer"==navigator.appName){
                var r=navigator.userAgent;null!=new RegExp("MSIE ([0-9]{1,}[.0-9]{0,})").exec(r)&&(e=parseFloat(RegExp.$1))
            }
                return e
        }
        
        function supportIE(){
            var e=getInternetExplorerVersion();
            return!(-1<e&&e<9)
        }
        
        function ie9(){
            var e=getInternetExplorerVersion();
            return-1<e&&e<10
        }
        </script>
</head>
<body>
        <!-- 헤더 -->
        <header id="header"></header>
        
        <!-- 본문 작성 -> 1200px 기준 -->
        <div class="container information-on"> </div>
        
        <!-- 푸터 -->
        <footer id="footer"></footer>
        
        <script src="../css&js/common/common.js"></script>
        <script src="../css&js/common/header.js"></script>
        <script src="../css&js/common/footer.js"></script>
        <script src="../css&js/information/information.js"></script>
        
</body>
</html>