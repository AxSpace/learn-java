<h1>${title}</h1>

<ul>
    <#list users as user>
        <li>
            <strong>Name:</strong> ${user.name}, <strong>Age:</strong> ${user.age}
        </li>
    </#list>
</ul>