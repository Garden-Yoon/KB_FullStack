<!-- 계층
부모 App2.vue
App2의 자식 ScopedSlotTest
ScopedSlotTest의 자식이 CheckBoxList
-->

<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은 ? (네번째 ScopedSlot)</h3>
    <CheckBoxList :items="items" @check-changed="CheckBoxChanged">
      <template v-slot:icon="p1">
        <!-- 체크박스의 체크여부에 따라 다른 아이콘 출력 -->
        <i v-if="p1.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-frown"></i>
      </template>
      <!-- 다른 슬롯에서 받아온 값은 사용할 수 없다 => 범위 슬롯 -->
      <template v-slot:default="p2">
        <!-- 체크박스의 체크여부에 따라 다른 스타일 출력 -->
        <span v-if="p2.checked" style="color: blue; text-decoration: underline">
          <i>{{ p2.label }}</i>
        </span>
        <span v-else style="color: gray">{{ p2.label }}</span>
      </template>
    </CheckBoxList>
  </div>
</template>

<script>
import CheckBoxList from './CheckBoxList.vue';
export default {
  name: 'ScopedSlotTest',
  components: { CheckBoxList },
  data() {
    return {
      items: [
        { id: 'v', checked: true, label: 'Vue' },
        { id: 'a', checked: false, label: 'Angular' },
        { id: 'r', checked: false, label: 'React' },
        { id: 's', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      // 변경된 체크박스의 id로 현재 items 배열에서 해당 요소를 찾는다
      let item = this.items.find((item) => item.id === e.id);
      item.checked = e.checked;
    },
  },
};
</script>

<style>
/* fontawesome 적용 */
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css');
</style>
