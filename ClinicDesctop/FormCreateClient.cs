using ClinicServiceNamespace;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClinicDesctop
{
    public partial class FormCreateClient : Form
    {
        private bool isUpdate;

        private ClinicClient clinicClient = new ClinicClient("http://localhost:5299/", new HttpClient());

        public FormCreateClient(bool isUpdate)
        {
            InitializeComponent();
            numericUpDown1.Enabled = isUpdate;
            this.isUpdate = isUpdate;
        }

        private void cancel_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void save_Click(object sender, EventArgs e)
        {
            if (!isUpdate)
            {
                createClient(sender, e);
            }
            else
            {
                updateClient(sender, e);
            }
        }

        private void createClient(object sender, EventArgs e)
        {
            int countCreate = clinicClient.ClientCreateAsync(new CreateClientRequest
            {
                Document = documentNumber.Text,
                SurName = surName.Text,
                FirstName = name.Text,
                Patronymic = patronymic.Text,
                Birthday = dateTimeBirthday.Value
            }).Result;

            Close();

            MessageBox.Show("Пользователь " + name.Text + " " + surName.Text + " добавлен.", "Добавлено "
                + countCreate + " пользователей");
        }

        private void updateClient(object sender, EventArgs e)
        {
            int value = (int)numericUpDown1.Value;

            int countUpdate = clinicClient.ClientUpdateAsync(new UpdateClientRequest
            {
                ClientId = value,
                Document = documentNumber.Text,
                SurName = surName.Text,
                FirstName = name.Text,
                Patronymic = patronymic.Text,
                Birthday = dateTimeBirthday.Value
            }).Result;

            if (countUpdate == 0)
            {
                MessageBox.Show("Пользователь c номером " + value + " несуществует",
                    "Ошибка",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
                return;
            }

            Close();

            MessageBox.Show("Пользователь " + name.Text + " " + surName.Text + " обновлен.", "Обновлено "
                + countUpdate + " пользователей");
        }
    }
}
