<template>
  <div>
    <h2>최신 인기곡</h2>
    <!-- songs를 props로 SongList에게 넘겨줌 -->
    <SongList :songs="songs" />
    <br />
    <button @click="changeModal">Teleport를 이용한 Modal 기능</button>
    <teleport to="#modal"> <Modal v-if="isModal" /></teleport>
  </div>
</template>

<script>
import { computed } from 'vue';
import SongList from './components/SongList.vue';
import Modal from './components/Modal.vue';
export default {
  name: 'App',
  components: { SongList, Modal },
  data() {
    return {
      songs: [
        { id: 1, title: ' Blueming', done: true },
        { id: 2, title: ' dynamite', done: true },
        { id: 3, title: ' Lovesick Girls', done: false },
        { id: 4, title: ' 마리아(Maria)', done: false },
      ],
      isModal: false,
    };
  },
  methods: {
    changeModal() {
      this.isModal = true;
      setTimeout(() => {
        this.isModal = false;
      }, 2000);
    },
  },
  // provide : 하위 컴포넌트에 속성이나 함수를 전달할 수 있음
  // 부모 컴포넌트에서 제공해야 함
  provide() {
    return {
      icons: {
        checked: 'far fa-check-circle',
        unchecked: 'far fa-circle',
      },
      // 현재 노래 목록에서 done이 true인 항목을 리스트로 반환 => 1번, 2번 항목
      // length : 필터링된 항목이 들어있는 배열의 길이 => 2
      doneCount: computed(() => {
        return this.songs.filter((s) => s.done === true).length;
      }),
    };
  },
};
</script>

<style>
/* fontawesome 적용 */
@import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css);
</style>
