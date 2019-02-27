<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
	<style type="text/css">
		.auto-style1 {
			width: 100%;
		}
		.auto-style2 {
			width: 189px;
		}
		.auto-style3 {
			color: #6666FF;
		}
		.auto-style4 {
			width: 189px;
			height: 23px;
		}
		.auto-style5 {
			height: 23px;
			text-align: left;
		}
		.auto-style6 {
			margin-left: 0px;
		}
		.auto-style7 {
			width: 189px;
			height: 30px;
		}
		.auto-style8 {
			height: 30px;
		}
	</style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        	<table align="center" class="auto-style1">
				<tr>
					<td class="auto-style2">&nbsp;</td>
					<td class="auto-style3"><strong>WEB FORM</strong></td>
				</tr>
				<tr>
					<td class="auto-style2">Name</td>
					<td>
						<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1" ErrorMessage="Required" ForeColor="#FF3300"></asp:RequiredFieldValidator>
					</td>
				</tr>
				<tr>
					<td class="auto-style2">Address</td>
					<td><asp:TextBox ID="TextBox2" runat="server"></asp:TextBox><asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="TextBox2" ErrorMessage="Required" ForeColor="#FF3300"></asp:RequiredFieldValidator></td></tr><tr><td class="auto-style4">Gender</td>
					<td class="auto-style5">
						<asp:RadioButtonList ID="RadioButtonList1" runat="server" CssClass="auto-style6" RepeatDirection="Horizontal" Width="141px" OnSelectedIndexChanged="RadioButtonList1_SelectedIndexChanged">
							<asp:ListItem Selected="True">Male</asp:ListItem>
							<asp:ListItem>Female</asp:ListItem>
						</asp:RadioButtonList>
					</td>
				</tr>
				<tr>
					<td class="auto-style2">Email</td>
					<td>
						<asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" ControlToValidate="TextBox3" ErrorMessage="Required" ForeColor="#FF3300"></asp:RequiredFieldValidator>
					</td>
				</tr>
				<tr>
					<td class="auto-style7">Username</td>
					<td class="auto-style8">
						<asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ControlToValidate="TextBox4" ErrorMessage="RequiredFieldValidator" ForeColor="#FF3300">Required</asp:RequiredFieldValidator>
					</td>
				</tr>
				<tr>
					<td class="auto-style2">Password</td>
					<td>
						<asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ControlToValidate="TextBox5" ErrorMessage="RequiredFieldValidator" ForeColor="#FF3300">Required</asp:RequiredFieldValidator>
					</td>
				</tr>
				<tr>
					<td class="auto-style7">Confirm Password</td>
					<td class="auto-style8">
						<asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" ControlToValidate="TextBox6" ErrorMessage="RequiredFieldValidator" ForeColor="#FF3300">Required</asp:RequiredFieldValidator>
					</td>
				</tr>
				<tr>
					<td class="auto-style2">Photo</td>
					<td>
						<asp:FileUpload ID="FileUpload1" runat="server" />
						<asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" ControlToValidate="FileUpload1" ErrorMessage="Required" ForeColor="#FF3300">Required</asp:RequiredFieldValidator>
					</td>
				</tr>
				<tr>
					<td class="auto-style2">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="auto-style2">&nbsp;</td>
					<td>
						<input id="Submit1" type="submit" value="Submit" /></td>
				</tr>
			</table>
        </div>
    </form>
</body>
</html>
