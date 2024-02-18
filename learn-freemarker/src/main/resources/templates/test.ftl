兹经（${endorsementApplyOrder.endorsementBaseInfo.applicantType.value}）${endorsementApplyOrder.endorsementBaseInfo.applicantName}申请，本公司同意自${(endorsementApplyOrder.endorsementBaseInfo.endorsementEffectiveTime)?string('yyyy年MM月dd日HH时')}起，对保险单号码：${endorsementApplyOrder.endorsementBaseInfo.policyNo}的保单作如下批改：
<br/>
批改内容：《险种专项信息批改》
<br/>
<#assign oldSchemePlanDTOList = originalPolicy.schemePlanDTOList />
<#assign newSchemePlanDTOList = correctingPolicy.schemePlanDTOList />
<#list oldSchemePlanDTOList as oldSchemePlan>
    <#list newSchemePlanDTOList as newSchemePlan>
        <#if oldSchemePlan.schemePlanCode == newSchemePlan.schemePlanCode>
            <#assign flag = false>
            <#assign bridgePercent = "">
            <#assign accordingToLaborPriceProposal = "">
            <#assign bridgeAndTunnelPercent = "">
            <#assign buildingArea = "">
            <#assign constructionUnit = "">
            <#assign constructionUnitCompetency = "">
            <#assign engineeringCost = "">
            <#assign laborPrice = "">
            <#assign projectAddress = "">
            <#assign livingAreaAddress = "">
            <#assign projectName = "">
            <#assign tunnelPercent = "">
            <#assign vinNo = "">

            <#assign vehiclePlateNo = "">

            <#assign licensePlateNo = "">

            <#if oldSchemePlan.extendInfo.bridgePercent??>

                <#if oldSchemePlan.extendInfo.bridgePercent != newSchemePlan.extendInfo.bridgePercent>

                    <#assign bridgePercent = "桥梁占比由" + oldSchemePlan.extendInfo.bridgePercent + "%修改为" + newSchemePlan.extendInfo.bridgePercent + "%。" />

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.bridgePercent??>

                <#assign bridgePercent = "桥梁占比由-修改为" + newSchemePlan.extendInfo.bridgePercent + "%。" />

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.accordingToLaborPriceProposalCd??>

                <#if oldSchemePlan.extendInfo.accordingToLaborPriceProposalCd != newSchemePlan.extendInfo.accordingToLaborPriceProposalCd>

                    <#assign accordingToLaborPriceProposal = "是否按照劳务价格投保由" + codeInfoMap['boolean_cd'][oldSchemePlan.extendInfo.accordingToLaborPriceProposalCd] + "修改为" + codeInfoMap['boolean_cd'][newSchemePlan.extendInfo.accordingToLaborPriceProposalCd] + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.accordingToLaborPriceProposalCd??>

                <#assign accordingToLaborPriceProposal = "是否按照劳务价格投保由-修改为" + codeInfoMap['boolean_cd'][newSchemePlan.extendInfo.accordingToLaborPriceProposalCd] + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.bridgeAndTunnelPercent??>

                <#if oldSchemePlan.extendInfo.bridgeAndTunnelPercent != newSchemePlan.extendInfo.bridgeAndTunnelPercent>

                    <#assign bridgeAndTunnelPercent = "桥隧占比合计由" + oldSchemePlan.extendInfo.bridgeAndTunnelPercent + "%修改为" + newSchemePlan.extendInfo.bridgeAndTunnelPercent + "%。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.bridgeAndTunnelPercent??>

                <#assign bridgeAndTunnelPercent = "桥隧占比合计由-修改为" + newSchemePlan.extendInfo.bridgeAndTunnelPercent + "%。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.buildingArea??>

                <#if oldSchemePlan.extendInfo.buildingArea != newSchemePlan.extendInfo.buildingArea>

                    <#assign buildingArea = "建筑面积由" + oldSchemePlan.extendInfo.buildingArea + "(平方米)修改为" + newSchemePlan.extendInfo.buildingArea + "(平方米)。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.buildingArea??>

                <#assign buildingArea = "建筑面积由-修改为" + newSchemePlan.extendInfo.buildingArea + "(平方米)。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.constructionUnit??>

                <#if oldSchemePlan.extendInfo.constructionUnit != newSchemePlan.extendInfo.constructionUnit>

                    <#assign constructionUnit = "施工单位由" + oldSchemePlan.extendInfo.constructionUnit + "修改为" + newSchemePlan.extendInfo.constructionUnit + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.constructionUnit??>

                <#assign constructionUnit = "施工单位由-修改为" + newSchemePlan.extendInfo.constructionUnit + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.constructionUnitCompetency??>

                <#if oldSchemePlan.extendInfo.constructionUnitCompetency != newSchemePlan.extendInfo.constructionUnitCompetency>

                    <#assign constructionUnitCompetency = "施工单位资质由" + codeInfoMap['const_enterprise_qual_cd'][oldSchemePlan.extendInfo.constructionUnitCompetency] + "修改为" + codeInfoMap['const_enterprise_qual_cd'][newSchemePlan.extendInfo.constructionUnitCompetency] + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.constructionUnitCompetency??>

                <#assign constructionUnitCompetency = "施工单位资质由-修改为" + "修改为" + codeInfoMap['const_enterprise_qual_cd'][newSchemePlan.extendInfo.constructionUnitCompetency] + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.engineeringCost??>

                <#if oldSchemePlan.extendInfo.engineeringCost != newSchemePlan.extendInfo.engineeringCost>

                    <#assign engineeringCost = "工程造价由" + oldSchemePlan.extendInfo.engineeringCost + "(元)修改为" + newSchemePlan.extendInfo.engineeringCost + "(元)。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.engineeringCost??>

                <#assign engineeringCost = "工程造价由-修改为" + newSchemePlan.extendInfo.engineeringCost + "(元)。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.laborPrice??>

                <#if oldSchemePlan.extendInfo.laborPrice != newSchemePlan.extendInfo.laborPrice>

                    <#assign laborPrice = "劳务价格由" + oldSchemePlan.extendInfo.laborPrice + "(元)修改为" + newSchemePlan.extendInfo.laborPrice + "(元)。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.laborPrice??>

                <#assign laborPrice = "劳务价格由-修改为" + newSchemePlan.extendInfo.laborPrice + "(元)。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.projectAddress??>

                <#if oldSchemePlan.extendInfo.projectAddress != newSchemePlan.extendInfo.projectAddress>

                    <#assign originalAddress=oldSchemePlan.extendInfo.projectAddress?eval>

                    <#assign correctingAddress=newSchemePlan.extendInfo.projectAddress?eval>

                    <#assign projectAddress = "工程地址由">

                    <#if originalAddress.provinceCode??>

                        <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][originalAddress.provinceCode]!'-/'>

                    </#if>

                    <#if originalAddress.cityCode??>

                        <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][originalAddress.cityCode]! "-/">

                    </#if>

                    <#if originalAddress.countyCode??>

                        <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][originalAddress.countyCode]!"-/">

                    </#if>

                    <#assign projectAddress = projectAddress + originalAddress.detailAddress + "修改为">

                    <#if correctingAddress.provinceCode??>

                        <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][correctingAddress.provinceCode]!'-/'>

                    </#if>

                    <#if correctingAddress.cityCode??>

                        <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][correctingAddress.cityCode]!'-/'>

                    </#if>

                    <#if correctingAddress.countyCode??>

                        <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][correctingAddress.countyCode]!'-/'>

                    </#if>

                    <#assign projectAddress = projectAddress + correctingAddress.detailAddress + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.projectAddress??>

                <#assign correctingAddress=newSchemePlan.extendInfo.projectAddress?eval>

                <#assign projectAddress = "工程地址由-修改为">

                <#if correctingAddress.provinceCode??>

                    <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][correctingAddress.provinceCode]!'-/'>

                </#if>

                <#if correctingAddress.cityCode??>

                    <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][correctingAddress.cityCode]!'-/'>

                </#if>

                <#if correctingAddress.countyCode??>

                    <#assign projectAddress = projectAddress + codeInfoMap['area_cd'][correctingAddress.countyCode]!'-/'>

                </#if>

                <#assign projectAddress = projectAddress + correctingAddress.detailAddress + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.livingAreaAddress??>

                <#if oldSchemePlan.extendInfo.livingAreaAddress != newSchemePlan.extendInfo.livingAreaAddress>

                    <#assign originalAddress=oldSchemePlan.extendInfo.livingAreaAddress?eval>

                    <#assign correctingAddress=newSchemePlan.extendInfo.livingAreaAddress?eval>

                    <#assign livingAreaAddress = "生活区域地址由">

                    <#if originalAddress.provinceCode??>

                        <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][originalAddress.provinceCode]!'-/'>

                    </#if>

                    <#if originalAddress.cityCode??>

                        <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][originalAddress.cityCode]!'-/'>

                    </#if>

                    <#if originalAddress.countyCode??>

                        <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][originalAddress.countyCode]!'-/'>

                    </#if>

                    <#assign livingAreaAddress = livingAreaAddress + originalAddress.detailAddress + "修改为">

                    <#if correctingAddress.provinceCode??>

                        <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][correctingAddress.provinceCode]!'-/'>

                    </#if>

                    <#if correctingAddress.cityCode??>

                        <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][correctingAddress.cityCode]!'-/'>

                    </#if>

                    <#if correctingAddress.countyCode??>

                        <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][correctingAddress.countyCode]!'-/'>

                    </#if>

                    <#assign livingAreaAddress = livingAreaAddress + correctingAddress.detailAddress + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.livingAreaAddress??>

                <#assign correctingAddress=newSchemePlan.extendInfo.livingAreaAddress?eval>

                <#assign livingAreaAddress = "生活区域地址由-修改为">

                <#if correctingAddress.provinceCode??>

                    <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][correctingAddress.provinceCode]!'-/'>

                </#if>

                <#if correctingAddress.cityCode??>

                    <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][correctingAddress.cityCode]!'-/'>

                </#if>

                <#if correctingAddress.countyCode??>

                    <#assign livingAreaAddress = livingAreaAddress + codeInfoMap['area_cd'][correctingAddress.countyCode]!'-/'>

                </#if>

                <#assign livingAreaAddress = livingAreaAddress + correctingAddress.detailAddress + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.projectName??>

                <#if oldSchemePlan.extendInfo.projectName != newSchemePlan.extendInfo.projectName>

                    <#assign projectName = "工程名称由" + oldSchemePlan.extendInfo.projectName + "修改为" + newSchemePlan.extendInfo.projectName + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.projectName??>

                <#assign projectName = "工程名称由-修改为" + newSchemePlan.extendInfo.projectName + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.tunnelPercent??>

                <#if oldSchemePlan.extendInfo.tunnelPercent != newSchemePlan.extendInfo.tunnelPercent>

                    <#assign tunnelPercent = "隧道占比由" + oldSchemePlan.extendInfo.tunnelPercent + "%修改为" + newSchemePlan.extendInfo.tunnelPercent + "%。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.tunnelPercent??>

                <#assign tunnelPercent = "隧道占比由-修改为" + newSchemePlan.extendInfo.tunnelPercent + "%。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.vinNo??>

                <#if oldSchemePlan.extendInfo.vinNo != newSchemePlan.extendInfo.vinNo>

                    <#assign vinNo = "车架号比由" + oldSchemePlan.extendInfo.vinNo + "修改为" + newSchemePlan.extendInfo.vinNo + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.vinNo??>

                <#assign vinNo = "车架号比由-修改为" + newSchemePlan.extendInfo.vinNo + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.vehiclePlateNo??>

                <#if oldSchemePlan.extendInfo.vehiclePlateNo != newSchemePlan.extendInfo.vehiclePlateNo>

                    <#assign vehiclePlateNo = "车牌号比由" + oldSchemePlan.extendInfo.vehiclePlateNo + "修改为" + newSchemePlan.extendInfo.vehiclePlateNo + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.vehiclePlateNo??>

                <#assign vehiclePlateNo = "车牌号比由-修改为" + newSchemePlan.extendInfo.vehiclePlateNo + "。">

                <#assign flag = true>

            </#if>

            <#if oldSchemePlan.extendInfo.licensePlateNo??>

                <#if oldSchemePlan.extendInfo.licensePlateNo != newSchemePlan.extendInfo.licensePlateNo>

                    <#assign licensePlateNo = "车牌号比由" + oldSchemePlan.extendInfo.licensePlateNo + "修改为" + newSchemePlan.extendInfo.licensePlateNo + "。">

                    <#assign flag = true>

                </#if>

            <#elseif newSchemePlan.extendInfo.licensePlateNo??>

                <#assign licensePlateNo = "车牌号比由-修改为" + newSchemePlan.extendInfo.licensePlateNo + "。">

                <#assign flag = true>

            </#if>

            <#if flag>

                保障组别${newSchemePlan.schemePlanCode}</br>

                <#if bridgePercent != "">

                    ${bridgePercent}</br>

                </#if>

                <#if accordingToLaborPriceProposal != "">

                    ${accordingToLaborPriceProposal}</br>

                </#if>
                <#if bridgeAndTunnelPercent != "">
                    ${bridgeAndTunnelPercent}</br>
                </#if>
                <#if buildingArea != "">
                    ${buildingArea}</br>
                </#if>
                <#if constructionUnit != "">
                    ${constructionUnit}</br>
                </#if>
                <#if constructionUnitCompetency != "">
                    ${constructionUnitCompetency}</br>
                </#if>
                <#if engineeringCost != "">
                    ${engineeringCost}</br>
                </#if>
                <#if laborPrice != "">
                    ${laborPrice}</br>
                </#if>
                <#if projectAddress != "">
                    ${projectAddress}</br>
                </#if>
                <#if livingAreaAddress != "">
                    ${livingAreaAddress}</br>
                </#if>
                <#if projectName != "">
                    ${projectName}</br>
                </#if>
                <#if tunnelPercent != "">
                    ${tunnelPercent}</br>
                </#if>
                <#if vinNo != "">
                    ${vinNo}</br>
                </#if>
                <#if vehiclePlateNo != "">
                    ${vehiclePlateNo}</br>
                </#if>
                <#if licensePlateNo != "">
                    ${licensePlateNo}</br>
                </#if>

            </#if>

        </#if>

    </#list>

</#list>


<p align='left'>本保险单所载的其他条件不变，特此批注。</p>
<#if CoinsuranceOtherFeeList??>
    <br/>
    <br/>
    兹经（${(endorsementApplyOrder.endorsementBaseInfo.applicantType.value)!}）${(endorsementApplyOrder.endorsementBaseInfo.applicantName)!}申请，本公司同意自${(endorsementApplyOrder.endorsementBaseInfo.endorsementEffectiveTime)?string('yyyy年MM月dd日HH时')}起，对保险单号码：${endorsementApplyOrder.endorsementBaseInfo.policyNo}的保单作如下批改：
    <table style='border-collapse: collapse;' border='1'>
        <tr align='center'>
            <th></th>
            <th colspan='4'>变更前</th>
            <th colspan='4'>变更后</th>
        </tr>
        <tr>
            <th>共保公司</th>
            <th>保额</th>
            <th>含税保费</th>
            <th>不含税保费</th>
            <th>增值税额</th>
            <th>保额</th>
            <th>含税保费</th>
            <th>不含税保费</th>
            <th>增值税额</th>
        </tr>
        <#list CoinsuranceOtherFeeList as coinsuranceApprovalModel>
            <tr>
                <th>${coinsuranceApprovalModel.companyName}</th>
                <th>${coinsuranceApprovalModel.amountBefore}</th>
                <th>${coinsuranceApprovalModel.premiumBefore}</th>
                <th>${coinsuranceApprovalModel.premiumNoTaxBefore}</th>
                <th>${coinsuranceApprovalModel.taxAmountBefore}</th>
                <th>${coinsuranceApprovalModel.amountAfter}</th>
                <th>${coinsuranceApprovalModel.premiumAfter}</th>
                <th>${coinsuranceApprovalModel.premiumNoTaxAfter}</th>
                <th>${coinsuranceApprovalModel.taxAmountAfter}</th>
            </tr>

        </#list>

    </table>

    本保险单所载的其他条件不变，特此批改。

</#if>