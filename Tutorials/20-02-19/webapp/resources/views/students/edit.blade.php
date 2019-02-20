<form method="POST" action="{{  route('student.update',$students->id)  }}"><br/>
@method('PATCH')<br/>
@csrf
Name  :<input type="text" name="name" value="{{ $students->name}}"><br/><br/>
Rollno:<input type="text" name="rno" value="{{ $students->rno}}"><br/><br/>
dept:<input type="text" name="dept" value="{{ $students->dept}}"><br/><br/>
class:<input type="text" name="class" value="{{ $students->class}}"><br/><br/>
age:<input type="text" name="age" value="{{ $students->age}}"><br/><br/>
<button type="submit">Update</button>
</form>