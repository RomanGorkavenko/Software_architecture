namespace ClinicDesctop
{
    partial class Delete
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            cancel = new Button();
            btnDelete = new Button();
            numberTitle = new Label();
            numericUpDown1 = new NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)numericUpDown1).BeginInit();
            SuspendLayout();
            // 
            // cancel
            // 
            cancel.Location = new Point(209, 167);
            cancel.Name = "cancel";
            cancel.Size = new Size(169, 51);
            cancel.TabIndex = 16;
            cancel.Text = "Отмена";
            cancel.UseVisualStyleBackColor = true;
            cancel.Click += cancel_Click;
            // 
            // btnDelete
            // 
            btnDelete.Location = new Point(411, 167);
            btnDelete.Name = "btnDelete";
            btnDelete.Size = new Size(169, 51);
            btnDelete.TabIndex = 15;
            btnDelete.Text = "Удалить";
            btnDelete.UseVisualStyleBackColor = true;
            btnDelete.Click += btnDelete_Click;
            // 
            // numberTitle
            // 
            numberTitle.AutoSize = true;
            numberTitle.BackColor = SystemColors.ControlLight;
            numberTitle.Location = new Point(31, 37);
            numberTitle.Name = "numberTitle";
            numberTitle.Size = new Size(295, 74);
            numberTitle.TabIndex = 14;
            numberTitle.Text = "Введите № клиента,\r\nкорого хотите удалить";
            numberTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // numericUpDown1
            // 
            numericUpDown1.Location = new Point(384, 51);
            numericUpDown1.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            numericUpDown1.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            numericUpDown1.Name = "numericUpDown1";
            numericUpDown1.Size = new Size(196, 43);
            numericUpDown1.TabIndex = 17;
            numericUpDown1.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // Delete
            // 
            AutoScaleDimensions = new SizeF(15F, 37F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLight;
            ClientSize = new Size(625, 252);
            Controls.Add(numericUpDown1);
            Controls.Add(cancel);
            Controls.Add(btnDelete);
            Controls.Add(numberTitle);
            FormBorderStyle = FormBorderStyle.None;
            Name = "Delete";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Delete";
            ((System.ComponentModel.ISupportInitialize)numericUpDown1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private Button cancel;
        private Button btnDelete;
        private Label numberTitle;
        private NumericUpDown numericUpDown1;
    }
}