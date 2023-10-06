namespace ClinicDesctop
{
    partial class FormCreateConsultation
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
            Id = new NumericUpDown();
            IdTitle = new Label();
            dateTimeConsultation = new DateTimePicker();
            TitleDescription = new Label();
            Description = new TextBox();
            titleDateTimeConsultation = new Label();
            NumberPetTitle = new Label();
            cancel = new Button();
            save = new Button();
            NumberClientTitle = new Label();
            NumberClient = new NumericUpDown();
            NumberPet = new NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)Id).BeginInit();
            ((System.ComponentModel.ISupportInitialize)NumberClient).BeginInit();
            ((System.ComponentModel.ISupportInitialize)NumberPet).BeginInit();
            SuspendLayout();
            // 
            // Id
            // 
            Id.Location = new Point(417, 49);
            Id.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            Id.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            Id.Name = "Id";
            Id.Size = new Size(196, 43);
            Id.TabIndex = 33;
            Id.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // IdTitle
            // 
            IdTitle.AutoSize = true;
            IdTitle.Location = new Point(32, 33);
            IdTitle.Name = "IdTitle";
            IdTitle.Size = new Size(337, 74);
            IdTitle.TabIndex = 32;
            IdTitle.Text = "Введите № консультации,\r\nкоторую хотите обновить\r\n";
            IdTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // dateTimeConsultation
            // 
            dateTimeConsultation.CalendarFont = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            dateTimeConsultation.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            dateTimeConsultation.Location = new Point(417, 264);
            dateTimeConsultation.Name = "dateTimeConsultation";
            dateTimeConsultation.Size = new Size(389, 47);
            dateTimeConsultation.TabIndex = 31;
            // 
            // TitleDescription
            // 
            TitleDescription.AutoSize = true;
            TitleDescription.Location = new Point(48, 375);
            TitleDescription.Name = "TitleDescription";
            TitleDescription.Size = new Size(253, 74);
            TitleDescription.TabIndex = 30;
            TitleDescription.Text = "Введите номер\r\nдокумента клиента";
            TitleDescription.TextAlign = ContentAlignment.TopCenter;
            // 
            // Description
            // 
            Description.Font = new Font("Segoe UI", 9F, FontStyle.Regular, GraphicsUnit.Point);
            Description.Location = new Point(417, 375);
            Description.Multiline = true;
            Description.Name = "Description";
            Description.Size = new Size(389, 276);
            Description.TabIndex = 29;
            Description.Tag = "";
            Description.Text = "Описание";
            // 
            // titleDateTimeConsultation
            // 
            titleDateTimeConsultation.AutoSize = true;
            titleDateTimeConsultation.Location = new Point(53, 252);
            titleDateTimeConsultation.Name = "titleDateTimeConsultation";
            titleDateTimeConsultation.Size = new Size(249, 74);
            titleDateTimeConsultation.TabIndex = 28;
            titleDateTimeConsultation.Text = "Введите дату\r\nрождения клиента";
            titleDateTimeConsultation.TextAlign = ContentAlignment.TopCenter;
            // 
            // NumberPetTitle
            // 
            NumberPetTitle.AutoSize = true;
            NumberPetTitle.Location = new Point(48, 187);
            NumberPetTitle.Name = "NumberPetTitle";
            NumberPetTitle.Size = new Size(268, 37);
            NumberPetTitle.TabIndex = 25;
            NumberPetTitle.Text = "Введите № питомца";
            NumberPetTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // cancel
            // 
            cancel.Location = new Point(444, 678);
            cancel.Name = "cancel";
            cancel.Size = new Size(169, 52);
            cancel.TabIndex = 23;
            cancel.Text = "Отмена";
            cancel.UseVisualStyleBackColor = true;
            cancel.Click += cancel_Click;
            // 
            // save
            // 
            save.Location = new Point(637, 678);
            save.Name = "save";
            save.Size = new Size(169, 52);
            save.TabIndex = 22;
            save.Text = "Сохранить";
            save.UseVisualStyleBackColor = true;
            save.Click += save_Click;
            // 
            // NumberClientTitle
            // 
            NumberClientTitle.AutoSize = true;
            NumberClientTitle.Location = new Point(53, 128);
            NumberClientTitle.Name = "NumberClientTitle";
            NumberClientTitle.Size = new Size(258, 37);
            NumberClientTitle.TabIndex = 21;
            NumberClientTitle.Text = "Введите № клиента";
            // 
            // NumberClient
            // 
            NumberClient.Location = new Point(417, 128);
            NumberClient.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            NumberClient.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            NumberClient.Name = "NumberClient";
            NumberClient.Size = new Size(196, 43);
            NumberClient.TabIndex = 34;
            NumberClient.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // NumberPet
            // 
            NumberPet.Location = new Point(417, 187);
            NumberPet.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            NumberPet.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            NumberPet.Name = "NumberPet";
            NumberPet.Size = new Size(196, 43);
            NumberPet.TabIndex = 35;
            NumberPet.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // FormCreateConsultation
            // 
            AutoScaleDimensions = new SizeF(15F, 37F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(851, 767);
            Controls.Add(NumberPet);
            Controls.Add(NumberClient);
            Controls.Add(Id);
            Controls.Add(IdTitle);
            Controls.Add(dateTimeConsultation);
            Controls.Add(TitleDescription);
            Controls.Add(Description);
            Controls.Add(titleDateTimeConsultation);
            Controls.Add(NumberPetTitle);
            Controls.Add(cancel);
            Controls.Add(save);
            Controls.Add(NumberClientTitle);
            FormBorderStyle = FormBorderStyle.None;
            Name = "FormCreateConsultation";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "FormCreateConsultation";
            ((System.ComponentModel.ISupportInitialize)Id).EndInit();
            ((System.ComponentModel.ISupportInitialize)NumberClient).EndInit();
            ((System.ComponentModel.ISupportInitialize)NumberPet).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private NumericUpDown Id;
        private Label IdTitle;
        private DateTimePicker dateTimeConsultation;
        private Label TitleDescription;
        private TextBox Description;
        private Label titleDateTimeConsultation;
        private Label NumberPetTitle;
        private Button cancel;
        private Button save;
        private Label NumberClientTitle;
        private NumericUpDown NumberClient;
        private NumericUpDown NumberPet;
    }
}