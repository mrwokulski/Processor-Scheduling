using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Liu
{
	public partial class Form1 : Form
	{
		#region Field

		private List<Task> _tasks;

		#endregion

		#region Contructor

		public Form1()
		{
			InitializeComponent();
			_tasks = new List<Task>();
		}

		#endregion

		#region Events

		private void btnAddTask_Click(object sender, EventArgs e)
		{
			var add = new AddTask(_tasks);
			add.Location = new Point(13, 42);
			add.Visible = true;
			Controls.Add(add);
		}

		private void btnCalculation_Click(object sender, EventArgs e)
		{
			if (_tasks.Any())
			{
				_tasks.ForEach(c =>
				{
					c.L = 0;
					c.EndTime = 0;
				});

				Bitmap bmp = new Bitmap(pictureBox1.Width, pictureBox1.Height);
				GetImageTaskOrder(bmp, GetTaskExecutionList());
				pictureBox1.Image = bmp;
				lblLMaxText.Visible = true;
				lblLMaxText.Text += _tasks.Max(c => c.L).ToString();
				RefreshTaskView();
			}
			else MessageBox.Show("Task list is empty, please add task and try again", "Warning!", MessageBoxButtons.OK);
		}

		#endregion Events

		#region Public method

		public void RefreshTaskView()
		{
			taskView.DataSource = null;
			taskView.DataSource = _tasks;
		}

		#endregion Public method

		#region Private method

		private static void GetImageTaskOrder(Bitmap bmp, List<string> tasksOrder)
		{
			using (var g = Graphics.FromImage(bmp))
			{
				const int WidthX = 30;
				const int HeightY = 30;
				Font _defaultFont = new Font("Arial", 9);
				for (int i = 0; i < tasksOrder.Count; i++)
				{
					int startPointX = i * WidthX;
					int startPointY = 20;
					Rectangle rectangele = new Rectangle(startPointX, startPointY, WidthX, HeightY);
					g.FillRectangle(tasksOrder[i] != "X" ? Brushes.BurlyWood : Brushes.DarkSlateBlue, rectangele);
					g.DrawString(i.ToString(), _defaultFont, Brushes.Black, startPointX, 0);
					g.DrawString(tasksOrder[i] != "X" ? "Z" + tasksOrder[i] : "", _defaultFont, Brushes.Black, rectangele);
					g.DrawRectangle(Pens.Black, rectangele);
				}
			}
		}

		private List<string> GetTaskExecutionList()
		{
			var tasks = new List<Task>(_tasks);
			List<string> taskOrder = new List<string>();
			int actualTimeUnit = 0;
			while (tasks.Sum(c => c.Time) > 0)
			{
				var availableTasks = tasks.Where(t => t.Time > 0 && actualTimeUnit >= t.StartTime);
				if (availableTasks.Any())
				{
					var task = availableTasks.OrderBy(c => c.ExpectEndTime).First();
					taskOrder.Add(task.Id.ToString());
					task.Time -= 1;
					if (task.Time == 0)
					{
						int endTime = actualTimeUnit + 1;
						var ta = _tasks.First(c => c.Id == task.Id);
						ta.EndTime = endTime;
						ta.L = endTime - ta.ExpectEndTime;
					}
				}
				else
				{
					taskOrder.Add("X");
				}
				actualTimeUnit += 1;
			}
			return taskOrder;
		}

		private void btnTestTasks_Click(object sender, EventArgs e)
		{
			_tasks.Add(new Task(1, 1, 0, 2));
			_tasks.Add(new Task(2, 2, 0, 5));
			_tasks.Add(new Task(3, 2, 2, 4));
			_tasks.Add(new Task(4, 2, 3, 10));
			_tasks.Add(new Task(5, 2, 6, 9));
			RefreshTaskView();
		}

		#endregion Private method
	}
}
