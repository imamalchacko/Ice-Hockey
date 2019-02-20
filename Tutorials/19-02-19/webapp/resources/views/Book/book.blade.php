<form action="{{ route('book.store') }}" method="POST">
@csrf
Title:<input type="text" name="title"><br><br>
Body:<input type="text" name="body"><br><br>
<button type="submit">Add</button>
</form>