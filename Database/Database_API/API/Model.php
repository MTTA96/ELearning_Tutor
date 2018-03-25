<?php
//Model quyền user
class AuthorizationTypes{
	function AuthorizationTypes($IdAuth,$AuthTypesName){
		$this->IdAuth=$IdAuth;
		$this->AuthTypesName=$AuthTypesName;
	}
}

//Model User( Student||Teacher)
class Users{
	function Users($Uid,$Avatar,$FirstName,$LastName,$Sex,$Birthday,$Email,$Phone,$Address,$Degree,$Career,$Status,$Verification,$Authorization,$DateRegisted){
		$this->Uid=$Uid;
		$this->Avatar=$Avatar;
		$this->FirstName=$FirstName;
		$this->LastName=$LastName;
		$this->Sex=$Sex;
		$this->Birthday=$Birthday;
		$this->Email=$Email;
		$this->Phone=$Phone;
		$this->Address=$Address;
		$this->Degree=$Degree;
		$this->Career=$Career;
		$this->Status=$Status;
		$this->Verification=$Verification;
		$this->Authorization=$Authorization;
		$this->DateRegisted=$DateRegisted;
	}
}

//Model Loại tài liệu xác minh
class VerificationDocumentsTypes{
	function VerificationDocumentsTypes($IdVdTypes,$VdTypesName	){
		$this->IdVdTypes=$IdVdTypes;
		$this->VdTypesName=$VdTypesName;
	}
}

//Model tài liệu xác minh của user 
class VerificationDocuments{
	function VerificationDocuments($Uid,$IdVdTypes,$CardNumbers,$FontSide,$BackSide){
		$this->Uid=$Uid;
		$this->IdVdTypes=$IdVdTypes;
		$this->CardNumbers=$CardNumbers;
		$this->FontSide=$FontSide;
		$this->BackSide=$BackSide;
	}
}

//Model đánh giá 
class Reviews{
	function Reviews($UidSender,$UidReceiver,$RatingPoint,$Comment,$DateSent){
		$this->UidSender=$UidSender;
		$this->UidReceiver=$UidReceiver;
		$this->RatingPoint=$RatingPoint;
		$this->Comment=$Comment;
		$this->DateSent=$DateSent;
	}
}

//Model danh sách lĩnh vực Fields
class Fields{
	function Fields($IdField,$FieldName){
		$this->IdField=$IdField;
		$this->FieldName=$FieldName;
	}
}

//Model danh sách môn 
class Subjects{
	function Subjects($IdSubject, $IdField, $SubjectName){
		$this->IdSubject=$IdSubject;
		$this->IdField=$IdField;
		$this->SubjectName=$SubjectName;
	}
}

//Model quyền CertificationTypes
class CertificationTypes{
	function CertificationTypes($IdCertificationTypes, $IdField, $CertificatipnTypesName){
		$this->IdCertificationTypes=$IdCertificationTypes;
        $this->IdField=$IdField;
        $this->CertificatipnTypesName=$CertificatipnTypesName;
	}
}

//Model quyền Certifications
class Certifications{
	function Certifications($Uid, $IdCertificationTypes, $Image){
		$this->Uid=$Uid;
        $this->IdCertificationTypes=$IdCertificationTypes;
        $this->Image=$Image;
	}
}

//Model quyền FieldsConcern
class FieldsConcern{
	function FieldsConcern($Uid, $IdField){
		$this->Uid=$Uid;
        $this->IdField=$IdField;
	}
}

//Model quyền Specialization
class Specialization{
	function Specialization($Uid, $IdField){
		$this->Uid=$Uid;
        $this->IdField=$IdField;
	}
}

//Model quyền SubjectDocuments
class SubjectDocuments{
	function SubjectDocuments($Uid, $IdSubject, $IdDocument, $Title, $ImageDoc, $Description){
		$this->Uid=$Uid;
        $this->IdSubject=$IdSubject;
        $this->IdDocument=$IdDocument;
        $this->Title=$Title;
        $this->ImageDoc=$ImageDoc;
        $this->Description=$Description;
	}
}

//Model quyền ContentDocument
class ContentDocument{
	function ContentDocument($IdDocument, $TypeContent, $Link){
		$this->IdDocument=$IdDocument;
        $this->TypeContent=$TypeContent;
        $this->Link=$Link;
	}
}

//Model quyền RequestionCourse
class ContentDocRequestionCourseument{
	function RequestionCourse($UidSender, $UidReceiver, $IdRequestionCourse, $CourseType, $SentDate, $IdSubject, $Tuition, $Address, $NumberOfSessions, $TimePerSession, $StudentNumber, $Schedule, $Description, $SenderConfirm, $ReceiverConfirm){
		$this->UidSender=$UidSender;
        $this->UidReceiver=$UidReceiver;
        $this->IdRequestionCourse=$IdRequestionCourse;
        $this->CourseType=$CourseType;
        $this->SentDate=$SentDate;
        $this->IdSubject=$IdSubject;
        $this->Tuition=$Tuition;
        $this->Address=$Address;
        $this->NumberOfSessions=$NumberOfSessions;
        $this->TimePerSession=$TimePerSession;
        $this->StudentNumber=$StudentNumber;
        $this->Schedule=$Schedule;
        $this->Description=$Description;
        $this->SenderConfirm=$SenderConfirm;
        $this->ReceiverConfirm=$ReceiverConfirm;
	}
}

//Model quyền Courses
class Courses{
	function Courses($Uid, $IdCourse, $CourseType, $CreatedDate, $Status, $IdSubject, $Tuition, $Address, $NumberOfSessions, $TimePerSession, $StudentNumber, $Schedule, $Description){
		$this->Uid=$Uid;
        $this->IdCourse=$IdCourse;
        $this->CourseType=$CourseType;
        $this->CreatedDate=$CreatedDate;
        $this->Status=$Status;
        $this->IdSubject=$IdSubject;
        $this->Tuition=$Tuition;
        $this->Address=$Address;
        $this->NumberOfSessions=$NumberOfSessions;
        $this->TimePerSession=$TimePerSession;
        $this->StudentNumber=$StudentNumber;
        $this->Schedule=$Schedule;
        $this->Description=$Description;
	}
}

//Model quyền Requestion
class Requestion{
	function Requestion($Uid, $IdCourse, $SentDate, $Status, $Message){
		$this->Uid=$Uid;
        $this->IdCourse=$IdCourse;
        $this->SentDate=$SentDate;
        $this->Status=$Status;
        $this->Message=$Message;
	}
}
?>