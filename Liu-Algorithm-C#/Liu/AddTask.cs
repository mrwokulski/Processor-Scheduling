using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Liu
{
	public partial class AddTask : UserControl
	{
		#region Field

		private List<Task> _tasks;

		#endregion Field

		#region Contructor

		public AddTask(List<Task> _tasks)
		{
			InitializeComponent();
			this._tasks = _tasks;
		}

		#endregion

		#region Events

		private void btnAdd_Click(object sender, EventArgs e)
		{
			if (VerifcationAllFieldAreFill())
			{
				bool isOk = true;

				int taskTime, taksStartTime, taskEndTime;
				if (!Int32.TryParse(tbTaskTime.Text, out taskTime))
				{
					lblErrorTime.Text = "Incorret time format, please intert only number!";
					lblErrorTime.Visible = true;
					isOk = false;
				}

				if (!Int32.TryParse(tbStartTime.Text, out taksStartTime))
				{
					lblErrorStartTime.Text = "Incorret time format, please intert only number!";
					lblErrorStartTime.Visible = true;
					isOk = false;
				}

				if (!Int32.TryParse(tbExpectEndTime.Text, out taskEndTime))
				{
					lblErrorEndTime.Text = "Incorret time format, please intert only number!";
					lblErrorEndTime.Visible = true;
					isOk = false;
				}

				if (isOk)
				{
					int id = 1;
					if (_tasks.Any())
						id = _tasks.OrderBy(c => c.Id).Last().Id + 1;
					Task task = new Task(id, taskTime, taksStartTime, taskEndTime);
					_tasks.Add(task);
					(this.Parent as Form1).RefreshTaskView();
				}
			}
		}

		private void btnCancel_Click(object sender, EventArgs e)
		{
			Dispose();
		}

		#endregion Events

		#region Private method

		private bool VerifcationAllFieldAreFill()
		{
			bool isOk = true;
			if (string.IsNullOrEmpty(tbTaskTime.Text))
			{
				lblErrorTime.Text = "Task time cant be empty!";
				lblErrorTime.Visible = true;
				isOk = false;
			}

			if (string.IsNullOrEmpty(tbStartTime.Text))
			{
				lblErrorStartTime.Text = "Start time cant be empty!";
				lblErrorStartTime.Visible = true;
				isOk = false;
			}

			if (string.IsNullOrEmpty(tbExpectEndTime.Text))
			{
				lblErrorEndTime.Text = "Expect end cant be empty!";
				lblErrorEndTime.Visible = true;
				isOk = false;
			}
			return isOk;
		}

		#endregion Private method
	}
}
