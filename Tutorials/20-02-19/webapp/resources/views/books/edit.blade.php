<form method="POST" action="{{  route('book.update',$books->id)  }}">
@method('PATCH')<br/>
@csrf
Title  :<input type="text" name="title" value="{{ $books->title}}"><br/><br/>
Body:<input type="text" name="body" value="{{ $books->body}}"><br/><br/>
<button type="submit">Update</button>
</form>