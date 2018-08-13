function requiredCheck(strVal,strErr) {
	if(strVal=="" || strVal==undefined){
		return strErr + "�͕K�{���͂ł� \r";
	}else{
		return "";
	}
}
function requiredRadioCheck(objElm,strErr) {
	flag=false;
	for(i=0;i<objElm.length;i++){
		if(objElm[i].checked){flag=true;}
	}
	if(!flag){
		return strErr + "�͕K�{���͂ł� \r";
	}else{
		return "";
	}
}
function lengthCheck(strVal,intMax,strErr) {
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		if(strVal.length>intMax){
			return strErr + "��" + intMax + "���ȉ��œ��͂��Ă������� \r"
		}else{
			return "";
		}
	}
}
function ZenCheck(strVal,strErr){
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		cnt=0;
		for(i=0;i<strVal.length;i++){
			if(escape(strVal.charAt(i)).length>=4){
				cnt+=2;
			}else{
				cnt++;
			}
		}
		if(cnt!=strVal.length*2){
			return strErr + "�͑S�p�i2�o�C�g�����j�œ��͂��Ă������� \r";
		}else{
			return "";
		}
	}
}
function HanCheck(strVal,strErr){
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		cnt=0;
		for(i=0;i<strVal.length;i++){
			if(escape(strVal.charAt(i)).length>=4){
				cnt+=2;
			}else{
				cnt++;
			}
		}
		if(cnt!=strVal.length){
			return strErr + "�͔��p�i1�o�C�g�����j�œ��͂��Ă������� \r";
		}else{
			return "";
		}
	}
}
function numberTypeCheck(strVal,strErr){
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		if(isNaN(strVal)){
			return strErr + "�͐��l�œ��͂��Ă������� \r";
		}else{
			return "";
		}
	}
}
function dateTypeCheck(strVal,strErr){
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		var objReg=new RegExp("^[0-9]{4}-[0-9]{2}-[0-9]{2}$","gi");
		if(!objReg.test(strVal)){
			return strErr + "�͓��t�`���œ��͂��Ă������� \r";
		}else{
			var strYear =strVal.substring(0,4);
			var strMonth=strVal.substring(5,7);
			var strDay  =strVal.substring(8,10);
			var tmpDat  =new Date(strYear,strMonth-1,strDay);
			if(strYear!=tmpDat.getFullYear() || strMonth-1!=tmpDat.getMonth() || strDay!=tmpDat.getDate()){
				return strErr + "�͓��t�`���œ��͂��Ă������� \r";
			}else{
				return "";
			}
		}
	}
}
function rangeCheck(strVal,intMax,intMin,strErr){
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		if(isNaN(strVal)){
			return strErr + "�͐��l�œ��͂��Ă������� \r";
		}else{
			intVal=parseInt(strVal,10);
			if(intVal<intMin || intVal>intMax){
				return strErr + "��" + intMin + "�ȏ�A����" + intMax + "�ȉ��œ��͂��Ă������� \r";
			}else{
				return "";
			}
		}
	}
}
function regExCheck(strVal,strPtn,strErr){
	if(strVal=="" || strVal==undefined){
		return ""
	}else{
		var objReg=new RegExp(strPtn,"gi");
		if(!objReg.test(strVal)){
			return strErr + "�𐳂����`���œ��͂��Ă������� \r";
		}else{
			return "";
		}
	}
}
