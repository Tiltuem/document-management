<#macro pagination link list>
    <div class="top-cover center-block offset-md-5">
    <nav aria-label="Page navigation example">
        <ul class="pagination pagination-lg ">
            <#if page gt 0>
                <li class="page-item"><a class="btn btn-my-two" href="/${link}/${page-1}"><i class="bi bi-chevron-left"></i></a>
                </li>
            <#else>
                <li class="page-item disabled"><a class="btn btn-my-two" href="/${link}/${page}"><i class="bi bi-chevron-left"></i></a>
                </li>
            </#if>
            <#if list.getTotalPages() gt page+1>
                <li class="page-item">
                    <a class="btn btn-my-two" href="/${link}/${page+1}"><i class="bi bi-chevron-right"></i></a>
                </li>
            <#else>
                <li class="page-item disabled">
                    <a class="btn btn-my-two" href="/${link}/${page}"><i class="bi bi-chevron-right"></i></a>
                </li>
            </#if>
        </ul>
    </nav>
    </div>
</#macro>