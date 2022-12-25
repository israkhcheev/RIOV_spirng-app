import { useState } from 'react';
import './App.css';
import CreateElementForm from './features/form/element';
import UpdateElementForm from './features/form/element update';
import CreateShopForm from './features/form/shop';
import MainTable from './features/mainTable';

let sectionSelect = [{ label: 'Товары' }, { label: 'Магазины' }]

function App() {

  const [section, setSection] = useState('Товары');
  const [state, setState] = useState(['Список']);

  const openList = (e) => {
    setSection(e);
    setState(['Список']);
  }
  
  const openUpdate = (e) => setState(['Обновление', e]);

  return (
    <div className="App">
      <div className="selector_container">
        {
          sectionSelect.map(({ label }, index) => (
            <button className={`select_button ${section === label && 'active_select_button'}`} onClick={() => { setSection(label); setState(['Список']) }} key={index}>{label}</button>
          ))
        }
      </div>

      {
        state[0] === 'Список' && <div className="button_form"> <button onClick={() => setState(['Создание'])}>Создать</button> </div>
      }

      <div className="content_container">
        {
          section === 'Товары' && state[0] === 'Создание' && <CreateElementForm close={() => openList('Товары')} />
        }
        {
          section === 'Товары' && state[0] === 'Список' && <MainTable head={['id', 'Названи', 'Цена']} body={['id', 'title', 'price']} endpoint={'element'} upd={openUpdate} />
        }
        {
          section === 'Товары' && state[0] === 'Обновление' && <UpdateElementForm idf={state[1]} close={() => openList('Товары')} />
        }
        {
          section === 'Магазины' && state[0] === 'Создание' && <CreateShopForm close={() => openList('Магазины')} />
        }
        {
          section === 'Магазины' && state[0] === 'Список' && <MainTable head={['id', 'Названи', 'Тип', 'Онлайн']} body={['id', 'name', 'type','online']} endpoint={'shop'} upd={openUpdate} />
        }

      </div>
    </div>
  );
}

export default App;
