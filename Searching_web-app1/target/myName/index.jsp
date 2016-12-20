<html>
<link rel="stylesheet" href="CSS/style.css">
<script src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="js/search.js" charset="UTF-8"></script>
<body>
<h2>Hello World from Perepelova</h2>
<div class = "searcher">
    <input class="searcherText" type="text" id="searchText">
    <button value="Search" id="search"><span>Search</span></button>
</div>
<div class="result">
    <textarea id="result" placeholder="Nothing to search=("><%= session.getAttribute("results")%></textarea>
</div>
</body>
</html>
