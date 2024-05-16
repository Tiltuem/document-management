<#macro pagination link list>
    <div class="top-cover center-block offset-md-5">
    <nav aria-label="Page navigation example">
        <ul class="pagination pagination-lg ">
                <li class="page-item"><a class="btn btn-my-two" id="paginationLinkFirst"><i class="bi bi-chevron-left"></i></a>
                </li>
                <li class="page-item">
                    <a class="btn btn-my-two" id="paginationLinkTwo"><i class="bi bi-chevron-right"></i></a>
                </li>
        </ul>
    </nav>
    </div>
    <script>
        url = window.location.href.toString();
        let modifiedURLFirst
        let modifiedURLTwo
        const searchIndex = url.lastIndexOf('/');
        const queryString = url.substring(searchIndex + 2);

        if (${page} < 1) {
            modifiedURLFirst = `${page}` + queryString;
        } else {
            modifiedURLFirst = `${page-1}` + queryString;
        }
        if (${list.getTotalPages()} > ${page+1}) {
            modifiedURLTwo = ${page+1} + queryString.toString();
        } else {
            modifiedURLTwo = url;
        }

        document.getElementById('paginationLinkFirst').href = modifiedURLFirst.toString();
        document.getElementById('paginationLinkTwo').href = modifiedURLTwo.toString();
    </script>
</#macro>