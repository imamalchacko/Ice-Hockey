<html>
<form method="POST" action="{{ route('student.store') }}">
@csrf
Name:<input type="text" name="name"><br><br>
Roll no:<input type="text" name="rno"><br><br>
dept:<input type="text" name="dept"><br><br>
class:<input type="text" name="class"><br><br>
age:<input type="text" name="age"><br><br>
<button type="submit">Add</button>
</form>
</html>