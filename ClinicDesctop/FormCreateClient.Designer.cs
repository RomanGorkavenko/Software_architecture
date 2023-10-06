namespace ClinicDesctop
{
    partial class FormCreateClient
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
            name = new TextBox();
            nameTitle = new Label();
            save = new Button();
            cancel = new Button();
            surNameTitle = new Label();
            surName = new TextBox();
            titlePatronymic = new Label();
            patronymic = new TextBox();
            titleBirthday = new Label();
            label4 = new Label();
            documentNumber = new TextBox();
            dateTimeBirthday = new DateTimePicker();
            numericUpDown1 = new NumericUpDown();
            numberTitle = new Label();
            ((System.ComponentModel.ISupportInitialize)numericUpDown1).BeginInit();
            SuspendLayout();
            // 
            // name
            // 
            name.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            name.Location = new Point(354, 109);
            name.Name = "name";
            name.Size = new Size(389, 47);
            name.TabIndex = 0;
            name.Tag = "";
            name.Text = "Имя";
            // 
            // nameTitle
            // 
            nameTitle.AutoSize = true;
            nameTitle.Location = new Point(50, 114);
            nameTitle.Name = "nameTitle";
            nameTitle.Size = new Size(277, 37);
            nameTitle.TabIndex = 1;
            nameTitle.Text = "Введите имя клиента";
            // 
            // save
            // 
            save.Location = new Point(574, 568);
            save.Name = "save";
            save.Size = new Size(169, 52);
            save.TabIndex = 2;
            save.Text = "Сохранить";
            save.UseVisualStyleBackColor = true;
            save.Click += save_Click;
            // 
            // cancel
            // 
            cancel.Location = new Point(383, 568);
            cancel.Name = "cancel";
            cancel.Size = new Size(169, 52);
            cancel.TabIndex = 3;
            cancel.Text = "Отмена";
            cancel.UseVisualStyleBackColor = true;
            cancel.Click += cancel_Click;
            // 
            // surNameTitle
            // 
            surNameTitle.AutoSize = true;
            surNameTitle.Location = new Point(61, 164);
            surNameTitle.Name = "surNameTitle";
            surNameTitle.Size = new Size(243, 74);
            surNameTitle.TabIndex = 5;
            surNameTitle.Text = "Введите фамилию\r\nклиента";
            surNameTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // surName
            // 
            surName.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            surName.Location = new Point(354, 181);
            surName.Name = "surName";
            surName.Size = new Size(389, 47);
            surName.TabIndex = 4;
            surName.Tag = "";
            surName.Text = "Фамилия";
            // 
            // titlePatronymic
            // 
            titlePatronymic.AutoSize = true;
            titlePatronymic.Location = new Point(68, 249);
            titlePatronymic.Name = "titlePatronymic";
            titlePatronymic.Size = new Size(232, 74);
            titlePatronymic.TabIndex = 7;
            titlePatronymic.Text = "Введите отчество\r\nклиента";
            titlePatronymic.TextAlign = ContentAlignment.TopCenter;
            // 
            // patronymic
            // 
            patronymic.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            patronymic.Location = new Point(354, 263);
            patronymic.Name = "patronymic";
            patronymic.Size = new Size(389, 47);
            patronymic.TabIndex = 6;
            patronymic.Tag = "";
            patronymic.Text = "Отчество";
            // 
            // titleBirthday
            // 
            titleBirthday.AutoSize = true;
            titleBirthday.Location = new Point(50, 340);
            titleBirthday.Name = "titleBirthday";
            titleBirthday.Size = new Size(249, 74);
            titleBirthday.TabIndex = 9;
            titleBirthday.Text = "Введите дату\r\nрождения клиента";
            titleBirthday.TextAlign = ContentAlignment.TopCenter;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(50, 437);
            label4.Name = "label4";
            label4.Size = new Size(253, 74);
            label4.TabIndex = 11;
            label4.Text = "Введите номер\r\nдокумента клиента";
            label4.TextAlign = ContentAlignment.TopCenter;
            // 
            // documentNumber
            // 
            documentNumber.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            documentNumber.Location = new Point(354, 452);
            documentNumber.Name = "documentNumber";
            documentNumber.Size = new Size(389, 47);
            documentNumber.TabIndex = 10;
            documentNumber.Tag = "";
            documentNumber.Text = "Номер документа";
            // 
            // dateTimeBirthday
            // 
            dateTimeBirthday.CalendarFont = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            dateTimeBirthday.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            dateTimeBirthday.Location = new Point(354, 358);
            dateTimeBirthday.Name = "dateTimeBirthday";
            dateTimeBirthday.Size = new Size(389, 47);
            dateTimeBirthday.TabIndex = 12;
            // 
            // numericUpDown1
            // 
            numericUpDown1.Location = new Point(359, 33);
            numericUpDown1.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            numericUpDown1.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            numericUpDown1.Name = "numericUpDown1";
            numericUpDown1.Size = new Size(196, 43);
            numericUpDown1.TabIndex = 19;
            numericUpDown1.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // numberTitle
            // 
            numberTitle.AutoSize = true;
            numberTitle.Location = new Point(28, 19);
            numberTitle.Name = "numberTitle";
            numberTitle.Size = new Size(317, 74);
            numberTitle.TabIndex = 18;
            numberTitle.Text = "Введите № клиента\r\nкорого хотите обновить\r\n";
            numberTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // FormCreateClient
            // 
            AutoScaleDimensions = new SizeF(15F, 37F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLight;
            ClientSize = new Size(776, 673);
            Controls.Add(numericUpDown1);
            Controls.Add(numberTitle);
            Controls.Add(dateTimeBirthday);
            Controls.Add(label4);
            Controls.Add(documentNumber);
            Controls.Add(titleBirthday);
            Controls.Add(titlePatronymic);
            Controls.Add(patronymic);
            Controls.Add(surNameTitle);
            Controls.Add(surName);
            Controls.Add(cancel);
            Controls.Add(save);
            Controls.Add(nameTitle);
            Controls.Add(name);
            FormBorderStyle = FormBorderStyle.None;
            Name = "FormCreateClient";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Создать клиента";
            ((System.ComponentModel.ISupportInitialize)numericUpDown1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox name;
        private Label nameTitle;
        private Button save;
        private Button cancel;
        private Label surNameTitle;
        private TextBox surName;
        private Label titlePatronymic;
        private TextBox patronymic;
        private Label titleBirthday;
        private Label label4;
        private TextBox documentNumber;
        private DateTimePicker dateTimeBirthday;
        private NumericUpDown numericUpDown1;
        private Label numberTitle;
    }
}