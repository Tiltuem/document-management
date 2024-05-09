<#macro pagination link list>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if page gt 0>
                <li class="page-item"><a class="page-link" href="/${link}/${page-1}"><i class="bi bi-chevron-left"></i></a>
                </li>
            </#if>
            <#if list.getTotalPages() gt page+1>
                <li class="page-item"><a class="page-link" href="/${link}/${page+1}"><i class="bi bi-chevron-right"></i></a>
                </li>
            </#if>
        </ul>
    </nav>
</#macro>